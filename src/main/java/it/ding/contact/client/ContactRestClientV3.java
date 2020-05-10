package it.ding.contact.client;

import static io.restassured.http.ContentType.JSON;
import static it.ding.contact.data.CommonData.PROPERTY_BASE_URI;

import io.restassured.response.Response;
import it.ding.contact.model.Contact;
import it.ding.contact.util.GlobalProperties;

public class ContactRestClientV3 extends RestClient {

    private static final GlobalProperties globalProperties = GlobalProperties.getInstance();

    private static final String BASE_URI = globalProperties.getString(PROPERTY_BASE_URI);

    private static final String BASE_PATH = "/api";

    private static final String CONTACTS = "/contacts";

    public ContactRestClientV3() {
        super(BASE_URI, BASE_PATH);
    }

//    public Response createContact(Contact contact) {
        // Implement this method
//    }
}
