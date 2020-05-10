package it.ding.contact.exercise18;

import static it.ding.contact.data.TestData.ADMIN;
import static it.ding.contact.data.TestData.ADMIN_PASSWORD;
import static it.ding.contact.util.ContactTestUtil.generateContactWithAllFieldsFilled;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

import it.ding.contact.client.ContactRestClientV10;
import it.ding.contact.client.LoginRestClient;
import it.ding.contact.model.Contact;
import it.ding.contact.model.ContactPostResponseBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AssertDeleteContactTest {

    private LoginRestClient loginRestClient = new LoginRestClient();

    private ContactRestClientV10 contactRestClient = new ContactRestClientV10();

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

        contactRestClient.deleteContact(contactId)
            .then()
            .statusCode(SC_OK);

        // Retrieve contacts by using the getContacts() method

        // Assert status code

        // Extract response body using .extract().as(ContactListGetResponseBody.class);

        // Assert contact list
//        assertThat(responseBody).isEqualTo();
    }

    @Test
    void cannotDeleteContactTwice() {
        Contact contact = generateContactWithAllFieldsFilled();

        Long contactId = contactRestClient.createContact(contact)
            .then()
            .statusCode(SC_CREATED)
            .extract()
            .as(ContactPostResponseBody.class)
            .getId();

        // Delete contact twice

        // Assert status code

    }
}
