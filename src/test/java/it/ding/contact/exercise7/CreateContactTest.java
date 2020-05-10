package it.ding.contact.exercise7;

import static it.ding.contact.data.TestData.ADMIN;
import static it.ding.contact.data.TestData.ADMIN_PASSWORD;

import it.ding.contact.client.ContactRestClientV2;
import it.ding.contact.client.LoginRestClient;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateContactTest {

    private LoginRestClient loginRestClient = new LoginRestClient();

    private ContactRestClientV2 contactRestClient = new ContactRestClientV2();

    @BeforeEach
    void login() {
        loginRestClient.login(ADMIN, ADMIN_PASSWORD);
    }

    @Test
    void canCreateContactWithMandatoryFieldsFilled() {
        Map<String, String> contact = new HashMap<>();

        contact.put("lastName", "Bond");
        contact.put("firstName", "James");
        contact.put("phone", "202-555-0185");

        contactRestClient.createContact(contact)
            .then()
            .statusCode(201);
    }

    @Test
    void canCreateContactWithAllFieldsFilled() {
        Map<String, String> contact = new HashMap<>();

        contact.put("lastName", "Bond");
        contact.put("firstName", "James");
        contact.put("phone", "202-555-0185");
        // Add other fields

        contactRestClient.createContact(contact)
            .then();
        // Assert status code
//            .statusCode();
    }

    @Test
    void cannotCreateContactWithMissingMandatoryFields() {
        Map<String, String> contact = new HashMap<>();

        // Create contact object with missing mandatory fields
//        contact.put();

        contactRestClient.createContact(contact)
            .then();
        // Assert status code
//            .statusCode();
    }

    @Test
    void cannotCreateContactWithInvalidEmailAddress() {
        Map<String, String> contact = new HashMap<>();

        // Create contact object with invalid e-mail address
//        contact.put();

        contactRestClient.createContact(contact)
            .then();
        // Assert status code
//            .statusCode();
    }
}
