//package it.ding.contact;
//
//import static io.restassured.RestAssured.given;
//import static it.ding.contact.data.CommonData.PROPERTY_BASE_URI;
//import static it.ding.contact.data.TestData.ADMIN;
//import static it.ding.contact.data.TestData.ADMIN_PASSWORD;
//import static it.ding.contact.util.ContactTestUtil.generateContactMapWithAllFieldsFilled;
//import static it.ding.contact.util.ContactTestUtil.generateContactWithAllFieldsFilled;
//import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
//import static org.apache.http.HttpStatus.SC_CREATED;
//import static org.apache.http.HttpStatus.SC_OK;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.CoreMatchers.notNullValue;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.hasSize;
//
//import io.restassured.http.ContentType;
//import it.ding.contact.client.ContactRestClient;
//import it.ding.contact.client.LoginRestClient;
//import it.ding.contact.model.Contact;
//import it.ding.contact.model.ContactListGetResponseBody;
//import it.ding.contact.model.ContactPostResponseBody;
//import it.ding.contact.model.ErrorResponseBody;
//import it.ding.contact.util.GlobalProperties;
//import java.util.List;
//import java.util.Map;
//import org.apache.commons.lang.RandomStringUtils;
//import org.junit.Before;
//import org.junit.Test;
//
//public class CreateContactTest {
//
//    private LoginRestClient loginRestClient = new LoginRestClient();
//    private ContactRestClient contactRestClient = new ContactRestClient();
//    private static final GlobalProperties globalProperties = GlobalProperties.getInstance();
//    private static final String BASE_URI = globalProperties.getString(PROPERTY_BASE_URI);
//
////    @Before
////    public void cleanUp() {
////        loginRestClient.login(ADMIN, ADMIN_PASSWORD);
////
////        List<Contact> existingContacts = contactRestClient.retrieveContacts(0, 200, null)
////            .then()
////            .statusCode(SC_OK)
////            .extract()
////            .as(ContactListGetResponseBody.class)
////            .getContent();
////
////        for (Contact existingContact : existingContacts) {
////            contactRestClient.deleteContact(existingContact.getId());
////        }
////    }
//
//    @Test
//    public void canLogin() {
//        Map<String, String> cookies = given().baseUri(BASE_URI)
//            .when()
//            .param("username", "admin")
//            .param("password", "admin")
//            .post("/login")
//            .then()
//            .statusCode(200)
//            .extract()
//            .cookies();
//
//        String id = given()
//            .log()
//            .all()
//            .baseUri(BASE_URI)
//            .contentType(ContentType.JSON)
//            .cookies(cookies)
//            .when()
//            .body(generateContactMapWithAllFieldsFilled())
//            .post("/api/contacts")
//            .then()
//            .statusCode(201)
//            .extract()
//            .jsonPath()
//            .getString("id");
//
//        System.out.println("id =============== " + id);
//    }
//
//    @Test
//    public void canCreateContact() {
//        Map<String, String> contact = generateContactMapWithAllFieldsFilled();
//
//        loginRestClient.login(ADMIN, ADMIN_PASSWORD);
//
//        ContactPostResponseBody contactPostResponseBody = contactRestClient.createContact(contact)
//            .then()
//            .statusCode(SC_CREATED)
//            .extract()
//            .as(ContactPostResponseBody.class);
//
//        assertThat(contactPostResponseBody.getId(), notNullValue());
//    }
//
//    @Test
//    public void canCreateContactWithPojo() {
//        Contact contact = generateContactWithAllFieldsFilled();
//
//        loginRestClient.login(ADMIN, ADMIN_PASSWORD);
//
//        ContactPostResponseBody contactPostResponseBody = contactRestClient.createContact(contact)
//            .then()
//            .statusCode(SC_CREATED)
//            .extract()
//            .as(ContactPostResponseBody.class);
//
//        Contact actualContact = contactRestClient.retrieveSingleContact(contactPostResponseBody.getId())
//            .then()
//            .statusCode(SC_OK)
//            .extract()
//            .as(Contact.class);
//
//        contact.setId(contactPostResponseBody.getId());
//        assertThat(actualContact, is(contact));
//    }
//
//    @Test
//    public void cannotCreateContactWithMissingMandatoryFieldFirstName() {
//        Contact contact = generateContactWithAllFieldsFilled();
//
//        contact.setFirstName(null);
//
//        ErrorResponseBody errorResponseBody = contactRestClient.createContact(contact)
//            .then()
//            .statusCode(SC_BAD_REQUEST)
//            .extract()
//            .as(ErrorResponseBody.class);
//
//        assertThat(errorResponseBody.getFieldErrors(), notNullValue());
//        assertThat(errorResponseBody.getFieldErrors().containsKey("firstName"), is(true));
//
//        List<Contact> actualContacts = contactRestClient.retrieveContacts()
//            .then()
//            .statusCode(SC_OK)
//            .extract()
//            .as(ContactListGetResponseBody.class)
//            .getContent();
//
//        assertThat(actualContacts.size(), is(0));
//    }
//
//    @Test
//    public void cannotCreateContactWithInvalidEmailAddress() {
//        Contact contact = generateContactWithAllFieldsFilled();
//
//        contact.setEmail(RandomStringUtils.randomAlphabetic(8));
//
//        ErrorResponseBody errorResponseBody = contactRestClient.createContact(contact)
//            .then()
//            .statusCode(SC_BAD_REQUEST)
//            .extract()
//            .as(ErrorResponseBody.class);
//
//        assertThat(errorResponseBody.getFieldErrors(), notNullValue());
//        assertThat(errorResponseBody.getFieldErrors().containsKey("email"), is(true));
//
//        List<Contact> actualContacts = contactRestClient.retrieveContacts()
//            .then()
//            .statusCode(SC_OK)
//            .extract()
//            .as(ContactListGetResponseBody.class)
//            .getContent();
//
//        assertThat(actualContacts.size(), is(0));
//    }
//
//}
