package it.ding.contact;

import static it.ding.contact.data.TestData.ADMIN;
import static it.ding.contact.data.TestData.ADMIN_PASSWORD;
import static it.ding.contact.util.ContactTestUtil.generateContactMapWithAllFieldsFilled;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import it.ding.contact.client.ContactRestClient;
import it.ding.contact.client.LoginRestClient;
import it.ding.contact.model.ContactPostResponseBody;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class CreateContactTest {

    private LoginRestClient loginRestClient = new LoginRestClient();
    private ContactRestClient contactRestClient = new ContactRestClient();

    @Before
    public void setUp() {
        loginRestClient.login(ADMIN, ADMIN_PASSWORD);
    }

    @Test
    public void canCreateContact() {
        Map<String, String> contact = generateContactMapWithAllFieldsFilled();

        loginRestClient.login(ADMIN, ADMIN_PASSWORD);

        ContactPostResponseBody contactPostResponseBody = contactRestClient.createContact(contact)
            .then()
            .statusCode(SC_CREATED)
            .extract()
            .as(ContactPostResponseBody.class);

        assertThat(contactPostResponseBody.getId(), notNullValue());
    }

}
