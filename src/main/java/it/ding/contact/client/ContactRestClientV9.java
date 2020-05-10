package it.ding.contact.client;

import static io.restassured.http.ContentType.JSON;
import static it.ding.contact.data.CommonData.PROPERTY_BASE_URI;

import io.restassured.response.Response;
import it.ding.contact.model.Contact;
import it.ding.contact.util.GlobalProperties;

public class ContactRestClientV9 extends RestClient {

    private static final GlobalProperties globalProperties = GlobalProperties.getInstance();

    private static final String BASE_URI = globalProperties.getString(PROPERTY_BASE_URI);

    private static final String BASE_PATH = "/api";

    private static final String CONTACTS = "/contacts";

    public ContactRestClientV9() {
        super(BASE_URI, BASE_PATH);
    }

    public Response createContact(Contact contact) {
        return requestSpec()
            .contentType(JSON)
            .body(contact)
            .post(CONTACTS);
    }

    public Response getContact(Long contactId) {
        return requestSpec()
            .contentType(JSON)
            .get(CONTACTS  + "/" + contactId);
    }

    public Response getContacts() {
        return requestSpec()
            .contentType(JSON)
            .get(CONTACTS);
    }

    public Response updateContact(Long contactId, Contact contact) {
        return requestSpec()
            .contentType(JSON)
            .body(contact)
            .put(CONTACTS + "/" + contactId);
    }

//    public Response deleteContact(Long contactId) {
//        // Implement this method
//    }
}
