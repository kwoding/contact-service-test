package it.ding.contact;

import it.ding.contact.client.ContactRestClient;
import it.ding.contact.client.LoginRestClient;
import org.junit.Before;
import org.junit.Test;

public class CreateContactTest {

    private LoginRestClient loginRestClient = new LoginRestClient();
    private ContactRestClient contactRestClient = new ContactRestClient();

    @Before
    public void setUp() {
        // Login

    }

    @Test
    public void canCreateContact() {
        // Construct request body (create key/value map)

        // Create contact via API (use ContactRestClient)

        // Assert HTTP status code, use `.then().status()` on the Response object

        // Assert response body (id is not null)
        // Mapping the response body can be done by `.then().extract().as(ClassName.class)`
    }
}
