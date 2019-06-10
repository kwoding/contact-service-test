package it.ding.contact;

import it.ding.contact.client.ContactRestClient;
import it.ding.contact.client.LoginRestClient;
import java.util.HashMap;
import java.util.Map;
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
        Map<String, String> contact = new HashMap<>();

        contact.put("key", "value");

        // Create contact via API (use ContactRestClient)

        // Assert HTTP status code, use `.then().statusCode()` on the Response object
        // Mapping the response body can be done by `.then().extract().as(ContactPostResponseBody.class)`

        // Assert response body (id is not null)
    }
}
