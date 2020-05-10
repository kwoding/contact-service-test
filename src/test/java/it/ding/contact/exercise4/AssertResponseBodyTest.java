package it.ding.contact.exercise4;

import static io.restassured.RestAssured.given;
import static it.ding.contact.data.CommonData.PROPERTY_BASE_URI;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import it.ding.contact.util.GlobalProperties;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AssertResponseBodyTest {

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
    void canAssertResponseBodyWithDefaultApi() {
        Long id = given()
            .log().all()
            .baseUri(BASE_URI)
            .contentType(ContentType.JSON)
            .cookies(cookies)
            .when()
            .body(contact)
            .post("/api/contacts")
            .then()
            .log().all()
            .statusCode(201)
            .extract().jsonPath().getLong("id");

        given()
            .log().all()
            .baseUri(BASE_URI)
            .contentType(ContentType.JSON)
            .cookies(cookies)
            .when()
            .body(contact)
            .get("/api/contacts/" + id)
            .then()
            .log().all()
            .statusCode(200);
        // Assert response by using .body()
//            .body("firstName", equalTo());

    }

    @Test
    void canAssertResponseBodyWithJsonPath() {
        Long id = given()
            .log().all()
            .baseUri(BASE_URI)
            .contentType(ContentType.JSON)
            .cookies(cookies)
            .when()
            .body(contact)
            .post("/api/contacts")
            .then()
            .log().all()
            .statusCode(201)
            .extract().jsonPath().getLong("id");

        given()
            .log().all()
            .baseUri(BASE_URI)
            .contentType(ContentType.JSON)
            .cookies(cookies)
            .when()
            .body(contact)
            .get("/api/contacts/" + id)
            .then()
            .log().all()
            .statusCode(200);
        // Extract response body as jsonPath, assign to variable named responseBody
//            .extract().jsonPath();

        // Assert response body for each field
//        assertThat(responseBody.getString("firstName")).isEqualTo();
    }
}
