package it.ding.contact.exercise14;

import static it.ding.contact.data.TestData.ADMIN;
import static it.ding.contact.data.TestData.ADMIN_PASSWORD;
import static org.apache.http.HttpStatus.SC_CREATED;

import it.ding.contact.client.ContactRestClientV8;
import it.ding.contact.client.LoginRestClient;
import it.ding.contact.model.Contact;
import it.ding.contact.model.ContactPostResponseBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UpdateContactTest {

    private LoginRestClient loginRestClient = new LoginRestClient();

    private ContactRestClientV8 contactRestClient = new ContactRestClientV8();

    @BeforeEach
    void login() {
        loginRestClient.login(ADMIN, ADMIN_PASSWORD);
    }

    @Test
    void canUpdateContact() {
        Contact contact = new Contact()
            .withLastName("Bond")
            .withFirstName("James")
            .withPhone("202-555-0185");

        Long contactId = contactRestClient.createContact(contact)
            .then()
            .statusCode(SC_CREATED)
            .extract()
            .as(ContactPostResponseBody.class)
            .getId();

        // Create new contact object to be used to update existing contact

        // Update the contact using the new updateContact method
//        contactRestClient.updateContact(contactId, newContact)

        // Assert status code
    }
}
