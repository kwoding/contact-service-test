package it.ding.contact.exercise15;

import static it.ding.contact.data.TestData.ADMIN;
import static it.ding.contact.data.TestData.ADMIN_PASSWORD;
import static it.ding.contact.util.ContactTestUtil.generateContactWithAllFieldsFilled;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_NO_CONTENT;
import static org.assertj.core.api.Assertions.assertThat;

import it.ding.contact.client.ContactRestClientV8;
import it.ding.contact.client.LoginRestClient;
import it.ding.contact.model.Contact;
import it.ding.contact.model.ContactPostResponseBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AssertUpdatedContactTest {

    private LoginRestClient loginRestClient = new LoginRestClient();

    private ContactRestClientV8 contactRestClient = new ContactRestClientV8();

    @BeforeEach
    void login() {
        loginRestClient.login(ADMIN, ADMIN_PASSWORD);
    }

    @Test
    void canAssertUpdatedContact() {
        Contact contact = generateContactWithAllFieldsFilled();

        Long contactId = contactRestClient.createContact(contact)
            .then()
            .statusCode(SC_CREATED)
            .extract()
            .as(ContactPostResponseBody.class)
            .getId();

        Contact newContact = generateContactWithAllFieldsFilled();

        contactRestClient.updateContact(contactId, newContact)
            .then()
            .statusCode(SC_NO_CONTENT);

        // Retrieve the contact by id

        // Extract response body using .extract().as(Contact.class);

        // Assert updated contact
//        assertThat(responseBody).isEqualTo();
    }
}
