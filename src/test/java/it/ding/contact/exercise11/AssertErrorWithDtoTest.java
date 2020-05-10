package it.ding.contact.exercise11;

import static it.ding.contact.data.TestData.ADMIN;
import static it.ding.contact.data.TestData.ADMIN_PASSWORD;

import it.ding.contact.client.ContactRestClientV5;
import it.ding.contact.client.LoginRestClient;
import it.ding.contact.model.Contact;
import it.ding.contact.model.ErrorResponseBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AssertErrorWithDtoTest {

    private LoginRestClient loginRestClient = new LoginRestClient();

    private ContactRestClientV5 contactRestClient = new ContactRestClientV5();

    @BeforeEach
    void login() {
        loginRestClient.login(ADMIN, ADMIN_PASSWORD);
    }

    @Test
    void canAssertErrorResponseUsingDto() {
        // Create contact object without phoneNumber
        Contact contact = new Contact();

        // Create contact
//        contactRestClient.createContact(contact)

        // Assert status code
//            .then()
        // Extract error response body
//            .extract().as(ErrorResponseBody.class)

        // Assert error response body
//        assertThat(responseBody).isEqualTo();
    }
}
