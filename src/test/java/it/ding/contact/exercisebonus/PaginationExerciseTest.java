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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaginationExerciseTest {

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

        // Create multiple contacts, use variable TOTAL_CONTACT_SIZE for the number of contacts to create

        // Save contact objects to contactList variable
    }

    @Test
    void canPaginateContacts() {
        // Note: Total number of pages = contactList.size() / size, see variable TOTAL_PAGES
        // Page size is 5, see variable PAGE_SIZE

        // Paginate/iterate through all pages

//        List<Contact> actualContacts = contactRestClient.getContacts(page, PAGE_SIZE)
//            .then()
//            .statusCode(SC_OK)
//            .extract()
//            .as(ContactListGetResponseBody.class)
//            .getContent();

        // Assert all contacts per page (note: one page = one iteration)
        // Make sure to sort contacts in actual and expected lists
//        assertThat(actualContacts).isEqualToComparingFieldByField(contactList);
    }

    @Test
    void noContactsWhenFromIsGreaterThanNumberOfPages() {
        // Retrieve contacts with getContacts method and query param page = greater than total number of pages

        // Assert that the response body is empty
    }
}
