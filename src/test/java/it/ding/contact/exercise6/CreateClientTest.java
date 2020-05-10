package it.ding.contact.exercise6;

import static it.ding.contact.data.TestData.ADMIN;
import static it.ding.contact.data.TestData.ADMIN_PASSWORD;

import it.ding.contact.client.ContactRestClientV1;
import it.ding.contact.client.LoginRestClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateClientTest {

    private LoginRestClient loginRestClient = new LoginRestClient();

    private ContactRestClientV1 contactRestClient = new ContactRestClientV1();

    @BeforeEach
    void login() {
        loginRestClient.login(ADMIN, ADMIN_PASSWORD);
    }

    @Test
    void canCreateContactWithReusableContactClient() {
        // Create contact with the newly created ContactRestClient
//        contactRestClient.
        // Assert status code (201)
//            .then()
    }
}
