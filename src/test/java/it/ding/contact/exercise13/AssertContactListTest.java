package it.ding.contact.exercise13;

import static it.ding.contact.data.TestData.ADMIN;
import static it.ding.contact.data.TestData.ADMIN_PASSWORD;
import static it.ding.contact.util.ContactTestUtil.generateContactWithAllFieldsFilled;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

import it.ding.contact.client.ContactRestClientV7;
import it.ding.contact.client.LoginRestClient;
import it.ding.contact.model.Contact;
import it.ding.contact.model.ContactListGetResponseBody;
import it.ding.contact.model.ContactPostResponseBody;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AssertContactListTest {

    private LoginRestClient loginRestClient = new LoginRestClient();

    private ContactRestClientV7 contactRestClient = new ContactRestClientV7();

    @BeforeEach
    void login() {
        loginRestClient.login(ADMIN, ADMIN_PASSWORD);
    }

    @Test
    void canAssertContactList() {
        List<Contact> expectedContacts = new ArrayList<>();

        IntStream.range(0, 5).forEach(contact -> {
            Contact newContact = generateContactWithAllFieldsFilled();

            Long contactId = contactRestClient.createContact(newContact)
                .then()
                .statusCode(SC_CREATED)
                .extract()
                .as(ContactPostResponseBody.class)
                .getId();

            newContact.setId(contactId);

            expectedContacts.add(newContact);
        });

        // Retrieve all contacts
        List<Contact> actualContacts = contactRestClient.getContacts()
            .then()
            .statusCode(SC_OK)
            .extract()
            .as(ContactListGetResponseBody.class)
            .getContent();

        assertThat(actualContacts).hasSameSizeAs(expectedContacts);

        actualContacts.sort(Comparator.comparing(Contact::getId));
        expectedContacts.sort(Comparator.comparing(Contact::getId));

        for (int i = 0; i < actualContacts.size(); i++) {
            assertThat(actualContacts.get(i)).isEqualToComparingFieldByField(expectedContacts.get(i));
        }
    }
}
