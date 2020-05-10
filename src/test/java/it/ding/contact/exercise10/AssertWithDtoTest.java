package it.ding.contact.exercise10;

import static it.ding.contact.data.TestData.ADMIN;
import static it.ding.contact.data.TestData.ADMIN_PASSWORD;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

import it.ding.contact.client.ContactRestClientV4;
import it.ding.contact.client.ContactRestClientV5;
import it.ding.contact.client.LoginRestClient;
import it.ding.contact.model.Contact;
import it.ding.contact.model.ContactPostResponseBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AssertWithDtoTest {

    private LoginRestClient loginRestClient = new LoginRestClient();

    private ContactRestClientV5 contactRestClient = new ContactRestClientV5();

    @BeforeEach
    void login() {
        loginRestClient.login(ADMIN, ADMIN_PASSWORD);
    }

    @Test
    void canAssertContactUsingDto() {
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

        contactRestClient.getContact(contactId)
            .then()
            .statusCode(SC_OK);
        // Extract response body by .extract().as(Contact.class)

        // Assert response body with the POSTed contact object
//        assertThat(responseBody).isEqualTo();
    }
}
