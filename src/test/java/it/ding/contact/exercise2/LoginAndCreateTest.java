package it.ding.contact.exercise2;

import static io.restassured.RestAssured.given;
import static it.ding.contact.data.CommonData.PROPERTY_BASE_URI;

import io.restassured.http.ContentType;
import it.ding.contact.util.GlobalProperties;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class LoginAndCreateTest {

    private static final GlobalProperties globalProperties = GlobalProperties.getInstance();

    private static final String BASE_URI = globalProperties.getString(PROPERTY_BASE_URI);

    @Test
    void canLoginAndCreateContact() {
        given()
            .log().all()
            .baseUri(BASE_URI)
            .when()
            .param("username", "admin")
            .param("password", "admin")
            .post("/login")
            .then()
            .log().all()
            .statusCode(200);
        // Extract cookies by adding .extract().cookies()

        // Create a contact with the cookies
        Map<String, String> contact = new HashMap<>();

        contact.put("lastName", "Bond");
        contact.put("firstName", "James");

        given()
            .log().all()
            .baseUri(BASE_URI)
            // Add contentType application/json: use ContentType.JSON
//            .contentType()
            // Add extracted cookies from logging in
//            .cookies()
            .when()
            // Add contact object as request body
//            .body()
            // Define endpoint to perform POST
//            .post()
            .then()
            .log().all()
            .statusCode(201);
    }
}
