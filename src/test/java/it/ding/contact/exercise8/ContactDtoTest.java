package it.ding.contact.exercise8;

import static it.ding.contact.data.TestData.ADMIN;
import static it.ding.contact.data.TestData.ADMIN_PASSWORD;

import it.ding.contact.client.ContactRestClientV2;
import it.ding.contact.client.ContactRestClientV3;
import it.ding.contact.client.LoginRestClient;
import it.ding.contact.model.Contact;
import it.ding.contact.model.ContactPostResponseBody;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactDtoTest {

    private LoginRestClient loginRestClient = new LoginRestClient();

    private ContactRestClientV3 contactRestClient = new ContactRestClientV3();

    @BeforeEach
    void login() {
        loginRestClient.login(ADMIN, ADMIN_PASSWORD);
    }

    @Test
    void canCreateContactUsingDto() {
        Contact contact = new Contact();

        // Create contact by passing the contact object to the createContact(Contact contact) method
//        contactRestClient.

        // Assert status code
//        .then()

        // Extract id from response body
//        .extract().as(ContactPostResponseBody.class);
    }
}
