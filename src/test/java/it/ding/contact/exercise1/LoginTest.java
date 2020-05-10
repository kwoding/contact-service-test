package it.ding.contact.exercise1;

import static io.restassured.RestAssured.given;
import static it.ding.contact.data.CommonData.PROPERTY_BASE_URI;

import it.ding.contact.util.GlobalProperties;
import org.junit.jupiter.api.Test;

public class LoginTest {

    private static final GlobalProperties globalProperties = GlobalProperties.getInstance();

    private static final String BASE_URI = globalProperties.getString(PROPERTY_BASE_URI);

    @Test
    void canLogin() {
        given()
            .log().all()
            .baseUri(BASE_URI)
            // Add param() to pass username/password
//            .param()
        .when()
            // Define endpoint to perform POST with .post()
            .post()
        .then()
            .log().all();
            // Assert statusCode (200)
//            .statusCode();
    }

    @Test
    void cannotLoginWithInvalidCredentials() {

        given()
            .log().all()
            .baseUri(BASE_URI)
            // Add param() to pass invalid username/password
//            .param()
        .when()
            // Define endpoint to perform POST with .post()
            .post()
        .then()
            .log().all();
            // Assert statusCode (401)
//            .statusCode();
    }
}
