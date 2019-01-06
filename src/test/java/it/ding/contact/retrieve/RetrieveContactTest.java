package it.ding.contact.retrieve;

import static it.ding.contact.data.TestData.ADMIN;
import static it.ding.contact.data.TestData.ADMIN_PASSWORD;
import static it.ding.contact.util.ContactTestUtil.generateContactWithAllFieldsFilled;
import static it.ding.contact.util.ContactTestUtil.sortContactsById;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;

import it.ding.contact.client.ContactRestClient;
import it.ding.contact.client.LoginRestClient;
import it.ding.contact.model.Contact;
import it.ding.contact.model.ContactListGetResponseBody;
import it.ding.contact.model.ContactPostResponseBody;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class RetrieveContactTest {

    private LoginRestClient loginRestClient = new LoginRestClient();
    private ContactRestClient contactRestClient = new ContactRestClient();
    private List<Contact> contactList = new ArrayList<>();

    @Before
    public void createContacts() {
        loginRestClient.login(ADMIN, ADMIN_PASSWORD);

        List<Contact> existingContacts = contactRestClient.retrieveContacts(0, 200, null)
            .then()
            .statusCode(SC_OK)
            .extract()
            .as(ContactListGetResponseBody.class)
            .getContent();

        for (Contact existingContact : existingContacts) {
            contactRestClient.deleteContact(existingContact.getId());
        }

        for (int i = 0; i < 105; i++) {
            Contact contact = generateContactWithAllFieldsFilled();

            ContactPostResponseBody contactPostResponseBody = contactRestClient.createContact(contact)
                .then()
                .statusCode(SC_CREATED)
                .extract()
                .as(ContactPostResponseBody.class);

            contact.setId(contactPostResponseBody.getId());

            contactList.add(contact);
        }
    }

    @Test
    public void canPaginateContacts() {
        int sizeField = 36;

        double numberOfPages = Math.ceil(contactList.size() / sizeField);
        for (int pageField = 0; pageField <= numberOfPages; pageField++) {

            List<Contact> actualContacts = contactRestClient.retrieveContacts(
                pageField,
                sizeField,
                "id,asc")
                .then()
                .statusCode(SC_OK)
                .extract()
                .as(ContactListGetResponseBody.class)
                .getContent();

            assertContacts(actualContacts, contactList, pageField, sizeField);
        }
    }

    @Test
    public void noContactsWhenFromIsGreaterThanNumberOfPages() {
        int sizeField = 24;

        double numberOfPages = Math.ceil(contactList.size() / sizeField);
        for (int pageField = (int) numberOfPages + 1; pageField <= 11; pageField++) {

            List<Contact> actualContacts = contactRestClient.retrieveContacts(
                pageField,
                sizeField,
                "id,asc")
                .then()
                .statusCode(SC_OK)
                .extract()
                .as(ContactListGetResponseBody.class)
                .getContent();

            assertThat(actualContacts.size(), is(0));
        }
    }

    private void assertContacts(List<Contact> actualContactList,
        List<Contact> expectedContactList, int page, int size) {
        sortContactsById(expectedContactList);

        int counter = page * size;
        for (Contact actualContact : actualContactList) {
            Contact expectedContact = expectedContactList.get(counter);

            assertThat(actualContact, samePropertyValuesAs(expectedContact));
            counter++;
        }
    }

}
