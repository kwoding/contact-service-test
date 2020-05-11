package it.ding.contact.exercise3;

import static io.restassured.RestAssured.given;
import static it.ding.contact.data.CommonData.PROPERTY_BASE_URI;

import io.restassured.http.ContentType;
import it.ding.contact.util.GlobalProperties;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateAndGetIdTest {

    private static final GlobalProperties globalProperties = GlobalProperties.getInstance();

    private static final String BASE_URI = globalProperties.getString(PROPERTY_BASE_URI);

    private Map<String, String> cookies;

    private Map<String, String> contact = new HashMap<>();

    @BeforeEach
    void login() {
        cookies = given()
            .log().all()
            .baseUri(BASE_URI)
            .param("username", "admin")
            .param("password", "admin")
            .when()
            .post("/login")
            .then()
            .log().all()
            .statusCode(200)
            .extract()
            .cookies();

        contact.put("lastName", "Bond");
        contact.put("firstName", "James");
        contact.put("phone", "202-555-0185");
    }

    @Test
    void canCreateContactAndGetId() {
        given()
            .log().all()
            .baseUri(BASE_URI)
            .contentType(ContentType.JSON)
            .cookies(cookies)
            .when()
            .body(contact)
            .post("/api/contacts")
            .then()
            .log().all()
            .statusCode(201);
            // Extract id from response body by adding .extract().jsonPath()
//            .extract().jsonPath().get()

        // Retrieve contact by performing a GET on /api/contacts/{contactId}
    }
}
