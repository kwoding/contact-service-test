package it.ding.contact.exercise17;

import static it.ding.contact.data.TestData.ADMIN;
import static it.ding.contact.data.TestData.ADMIN_PASSWORD;
import static it.ding.contact.util.ContactTestUtil.generateContactWithAllFieldsFilled;
import static org.apache.http.HttpStatus.SC_CREATED;

import it.ding.contact.client.ContactRestClientV9;
import it.ding.contact.client.LoginRestClient;
import it.ding.contact.model.Contact;
import it.ding.contact.model.ContactPostResponseBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeleteContactTest {

    private LoginRestClient loginRestClient = new LoginRestClient();

    private ContactRestClientV9 contactRestClient = new ContactRestClientV9();

    @BeforeEach
    void login() {
        loginRestClient.login(ADMIN, ADMIN_PASSWORD);
    }

    @Test
    void canDeleteContact() {
        Contact contact = generateContactWithAllFieldsFilled();

        Long contactId = contactRestClient.createContact(contact)
            .then()
            .statusCode(SC_CREATED)
            .extract()
            .as(ContactPostResponseBody.class)
            .getId();

        // Delete the contact using the new deleteContact method

        // Assert status code
    }
}
