package it.ding.contact.exercise9;

import static it.ding.contact.data.TestData.ADMIN;
import static it.ding.contact.data.TestData.ADMIN_PASSWORD;
import static org.apache.http.HttpStatus.SC_CREATED;

import it.ding.contact.client.ContactRestClientV4;
import it.ding.contact.client.LoginRestClient;
import it.ding.contact.model.Contact;
import it.ding.contact.model.ContactPostResponseBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExtendContactClientWithGetTest {

    private LoginRestClient loginRestClient = new LoginRestClient();

    private ContactRestClientV4 contactRestClient = new ContactRestClientV4();

    @BeforeEach
    void login() {
        loginRestClient.login(ADMIN, ADMIN_PASSWORD);
    }

    @Test
    void canCreateContactAndRetrieveUsingDto() {
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

        // Retrieve contact by id
//        contactRestClient.getContact(contactId)

        // Assert status code
    }
}
