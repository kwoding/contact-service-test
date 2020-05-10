package it.ding.contact.exercise12;

import static it.ding.contact.data.TestData.ADMIN;
import static it.ding.contact.data.TestData.ADMIN_PASSWORD;
import static org.apache.http.HttpStatus.SC_CREATED;

import it.ding.contact.client.ContactRestClientV5;
import it.ding.contact.client.LoginRestClient;
import it.ding.contact.model.Contact;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateMultipleContactsTest {

    private LoginRestClient loginRestClient = new LoginRestClient();

    private ContactRestClientV5 contactRestClient = new ContactRestClientV5();

    @BeforeEach
    void login() {
        loginRestClient.login(ADMIN, ADMIN_PASSWORD);
    }

    @Test
    void canCreateContactUsingDto() {
        // Create list of 5 contact objects
        List<Contact> contacts = new ArrayList<>();

        // Create all these contacts by iterating through the list
//        contactRestClient.createContact(contact)
//            .then()
//            .statusCode(SC_CREATED);

        // Retrieve all contacts
//        contactRestClient.getContacts()

        // Assert status code

    }
}
