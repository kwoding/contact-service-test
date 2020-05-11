package it.ding.contact.exercise13;

import static it.ding.contact.data.TestData.ADMIN;
import static it.ding.contact.data.TestData.ADMIN_PASSWORD;
import static it.ding.contact.util.ContactTestUtil.generateContactWithAllFieldsFilled;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.assertj.core.api.Assertions.assertThat;

import it.ding.contact.client.ContactRestClientV6;
import it.ding.contact.client.ContactRestClientV7;
import it.ding.contact.client.LoginRestClient;
import it.ding.contact.model.Contact;
import it.ding.contact.model.ContactListGetResponseBody;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AssertContactListExerciseTest {

    private LoginRestClient loginRestClient = new LoginRestClient();

    private ContactRestClientV7 contactRestClient = new ContactRestClientV7();

    @BeforeEach
    void login() {
        loginRestClient.login(ADMIN, ADMIN_PASSWORD);
    }

    @Test
    void canAssertContactList() {
        List<Contact> contacts = new ArrayList<>();

        IntStream.range(0, 5).forEach(i -> contacts.add(generateContactWithAllFieldsFilled()));

        contacts.forEach(contact -> contactRestClient.createContact(contact)
            .then()
            .statusCode(SC_CREATED));

        // Retrieve all contacts
//        contactRestClient.getContacts()

        // Assert status code

        // Extract response body
//        .extract().as(ContactListGetResponseBody.class);

        // Assert contact list (sort both lists before asserting)
//        assertThat(responseBody).isEqualTo(contacts);

    }
}
