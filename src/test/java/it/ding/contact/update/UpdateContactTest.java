package it.ding.contact.update;

import static it.ding.contact.data.TestData.ADMIN;
import static it.ding.contact.data.TestData.ADMIN_PASSWORD;
import static it.ding.contact.util.ContactTestUtil.generateContactWithAllFieldsFilled;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_NO_CONTENT;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import it.ding.contact.client.ContactRestClient;
import it.ding.contact.client.LoginRestClient;
import it.ding.contact.model.Contact;
import it.ding.contact.model.ContactPostResponseBody;
import org.junit.Test;

public class UpdateContactTest {

    private LoginRestClient loginRestClient = new LoginRestClient();
    private ContactRestClient contactRestClient = new ContactRestClient();

    @Test
    public void canUpdateContact() {
        Contact contact = generateContactWithAllFieldsFilled();
        Contact updatedContact = generateContactWithAllFieldsFilled();

        loginRestClient.login(ADMIN, ADMIN_PASSWORD);

        ContactPostResponseBody contactPostResponseBody = contactRestClient.createContact(contact)
            .then()
            .statusCode(SC_CREATED)
            .extract()
            .as(ContactPostResponseBody.class);

        contactRestClient.updateContact(contactPostResponseBody.getId(), updatedContact)
            .then()
            .statusCode(SC_NO_CONTENT);

        Contact actualContact = contactRestClient.retrieveSingleContact(contactPostResponseBody.getId())
            .then()
            .statusCode(SC_OK)
            .extract()
            .as(Contact.class);

        updatedContact.setId(contactPostResponseBody.getId());
        assertThat(actualContact, is(updatedContact));
    }

}
