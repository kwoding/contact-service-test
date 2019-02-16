package it.ding.contact.client;

import static io.restassured.http.ContentType.JSON;

import io.restassured.response.Response;
import java.util.Map;

public class ContactRestClient extends RestClient {

    private static final String BASE_URI = "http://localhost:8080/api";
    private static final String CONTACTS = "/contacts";

    public ContactRestClient() {
        super(BASE_URI);
    }

    public Response createContact(Map<String, String> contact) {
        return requestSpec()
            .contentType(JSON)
            .body(contact)
            .post(CONTACTS);
    }

}
