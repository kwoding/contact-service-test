package it.ding.contact.client;

import static io.restassured.http.ContentType.JSON;

import io.restassured.response.Response;
import it.ding.contact.model.Contact;
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

    public Response createContact(Contact contact) {
        return requestSpec()
            .contentType(JSON)
            .body(contact)
            .post(CONTACTS);
    }

    public Response retrieveContacts() {
        return requestSpec()
            .contentType(JSON)
            .get(CONTACTS);
    }

    public Response retrieveContacts(int page, int size) {
        return requestSpec()
            .contentType(JSON)
            .queryParam("page", page)
            .queryParam("size", size)
            .get(CONTACTS);
    }

    public Response retrieveSingleContact(Long contactId) {
        return requestSpec()
            .contentType(JSON)
            .get(CONTACTS  + "/" + contactId);
    }

    public Response updateContact(Long contactId, Contact contact) {
        return requestSpec()
            .contentType(JSON)
            .body(contact)
            .put(CONTACTS + "/" + contactId);
    }

    public Response deleteContact(Long contactId) {
        return requestSpec()
            .contentType(JSON)
            .delete(CONTACTS + "/" + contactId);
    }

}
