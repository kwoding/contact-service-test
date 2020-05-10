package it.ding.contact.client;

import static io.restassured.http.ContentType.JSON;
import static it.ding.contact.data.CommonData.PROPERTY_BASE_URI;

import io.restassured.response.Response;
import it.ding.contact.model.Contact;
import it.ding.contact.util.GlobalProperties;
import java.util.Map;

public class ContactRestClientV1 extends RestClient {

    private static final GlobalProperties globalProperties = GlobalProperties.getInstance();

    private static final String BASE_URI = globalProperties.getString(PROPERTY_BASE_URI);

    private static final String BASE_PATH = "/api";

    public ContactRestClientV1() {
        super(BASE_URI, BASE_PATH);
    }

    public Response createContact(Map<String, String> contact) {
        return requestSpec()
            .contentType(JSON)
            // Pass the contact map as request body
//            .body()
            // Define endpoint to perform POST
            .post();
    }

}
