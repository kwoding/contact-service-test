package it.ding.contact.exercisebonus;

import static it.ding.contact.data.TestData.ADMIN;
import static it.ding.contact.data.TestData.ADMIN_PASSWORD;
import static it.ding.contact.util.ContactTestUtil.generateContactWithAllFieldsFilled;
import static it.ding.contact.util.ContactTestUtil.sortContactsById;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

import it.ding.contact.client.ContactRestClient;
import it.ding.contact.client.LoginRestClient;
import it.ding.contact.model.Contact;
import it.ding.contact.model.ContactListGetResponseBody;
import it.ding.contact.model.ContactPostResponseBody;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaginationTest {

    private LoginRestClient loginRestClient = new LoginRestClient();

    private ContactRestClient contactRestClient = new ContactRestClient();

    private List<Contact> contactList = new ArrayList<>();

    private static final int PAGE_SIZE = 5;

    private static final int TOTAL_CONTACT_SIZE = 18;

    private static final double TOTAL_PAGES = Math.round(TOTAL_CONTACT_SIZE / PAGE_SIZE);

    @BeforeEach
    void createContacts() {
        loginRestClient.login(ADMIN, ADMIN_PASSWORD);

        List<Contact> existingContacts = contactRestClient.getContacts(0, 200)
            .then()
            .statusCode(SC_OK)
            .extract()
            .as(ContactListGetResponseBody.class)
            .getContent();

        for (Contact existingContact : existingContacts) {
            contactRestClient.deleteContact(existingContact.getId());
        }

        IntStream.range(0, TOTAL_CONTACT_SIZE).forEach(i -> {
            Contact contact = generateContactWithAllFieldsFilled();

            ContactPostResponseBody contactPostResponseBody = contactRestClient.createContact(contact)
                .then()
                .statusCode(SC_CREATED)
                .extract()
                .as(ContactPostResponseBody.class);

            contact.setId(contactPostResponseBody.getId());

            contactList.add(contact);
        });
    }

    @Test
    void canPaginateContacts() {
        for (int page = 0; page <= TOTAL_PAGES; page++) {
            List<Contact> actualContacts = contactRestClient.getContacts(
                page,
                PAGE_SIZE)
                .then()
                .statusCode(SC_OK)
                .extract()
                .as(ContactListGetResponseBody.class)
                .getContent();

            assertContacts(actualContacts, contactList, page, PAGE_SIZE);
        }
    }

    @Test
    void noContactsWhenPageIsGreaterThanNumberOfPages() {
        int startPage = (int) TOTAL_PAGES + 1;

        for (int page = startPage; page <= (startPage + 3); page++) {
            List<Contact> actualContacts = contactRestClient.getContacts(
                page,
                PAGE_SIZE)
                .then()
                .statusCode(SC_OK)
                .extract()
                .as(ContactListGetResponseBody.class)
                .getContent();

            assertThat(actualContacts).isEmpty();
        }
    }

    void assertContacts(List<Contact> actualContactList,
        List<Contact> expectedContactList, int page, int size) {
        sortContactsById(expectedContactList);

        int counter = page * size;
        for (Contact actualContact : actualContactList) {
            Contact expectedContact = expectedContactList.get(counter);

            assertThat(actualContact).isEqualToComparingFieldByField(expectedContact);
            counter++;
        }
    }
}
