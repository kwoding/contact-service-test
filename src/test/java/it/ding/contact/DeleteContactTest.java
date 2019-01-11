package it.ding.contact;

import static it.ding.contact.data.TestData.ADMIN;
import static it.ding.contact.data.TestData.ADMIN_PASSWORD;
import static it.ding.contact.util.ContactTestUtil.generateContactWithAllFieldsFilled;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_NO_CONTENT;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import it.ding.contact.client.ContactRestClient;
import it.ding.contact.client.LoginRestClient;
import it.ding.contact.model.Contact;
import it.ding.contact.model.ContactPostResponseBody;
import org.junit.Test;

public class DeleteContactTest {

    private LoginRestClient loginRestClient = new LoginRestClient();
    private ContactRestClient contactRestClient = new ContactRestClient();

    @Test
    public void canDeleteContact() {
        Contact contact = generateContactWithAllFieldsFilled();

        loginRestClient.login(ADMIN, ADMIN_PASSWORD);

        ContactPostResponseBody contactPostResponseBody = contactRestClient.createContact(contact)
            .then()
            .statusCode(SC_CREATED)
            .extract()
            .as(ContactPostResponseBody.class);

        contactRestClient.deleteContact(contactPostResponseBody.getId())
            .then()
            .statusCode(SC_OK);

        contactRestClient.retrieveSingleContact(contactPostResponseBody.getId())
            .then()
            .statusCode(SC_NOT_FOUND);
    }

}
