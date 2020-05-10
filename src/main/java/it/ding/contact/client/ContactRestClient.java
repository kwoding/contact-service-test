package it.ding.contact.client;

import static io.restassured.http.ContentType.JSON;
import static it.ding.contact.data.CommonData.PROPERTY_BASE_URI;

import io.restassured.response.Response;
import it.ding.contact.model.Contact;
import it.ding.contact.util.GlobalProperties;
import java.util.Map;

public class ContactRestClient extends RestClient {

    private static final GlobalProperties globalProperties = GlobalProperties.getInstance();

    private static final String BASE_URI = globalProperties.getString(PROPERTY_BASE_URI);

    private static final String BASE_PATH = "/api";

    private static final String CONTACTS = "/contacts";

    public ContactRestClient() {
        super(BASE_URI, BASE_PATH);
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

    public Response getContacts() {
        return requestSpec()
            .contentType(JSON)
            .get(CONTACTS);
    }

    public Response getContacts(int page, int size, String sortBy) {
        return requestSpec()
            .contentType(JSON)
            .queryParam("page", page)
            .queryParam("size", size)
            .queryParam("sort", sortBy == null ? "id,asc" : sortBy)
            .get(CONTACTS);
    }

    public Response getContact(Long contactId) {
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
