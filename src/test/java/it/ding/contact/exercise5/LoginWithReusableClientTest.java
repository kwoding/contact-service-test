package it.ding.contact.exercise5;

import static it.ding.contact.data.TestData.ADMIN;
import static it.ding.contact.data.TestData.ADMIN_PASSWORD;

import it.ding.contact.client.LoginRestClientV1;
import org.junit.jupiter.api.Test;

public class LoginWithReusableClientTest {

    private LoginRestClientV1 loginRestClient = new LoginRestClientV1();

    @Test
    void canLoginWithReusableClient() {
        // Login with LoginRestClient using the login() method
//        loginRestClient.
        // Assert status code (200)
    }

    @Test
    void cannotLoginWithInvalidCredentialsWithReusableClient() {
        // Login with LoginRestClientV1 using the login() method
//        loginRestClient.
        // Assert status code (401)
    }

}
