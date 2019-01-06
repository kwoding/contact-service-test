package it.ding.contact.client;

import static org.apache.http.HttpStatus.SC_OK;

import io.restassured.response.ValidatableResponse;
import java.util.HashMap;
import java.util.Map;

public class LoginRestClient extends RestClient {

    private static final String BASE_URI = "http://localhost:8080";
    private static final String LOGIN = "/login";

    public LoginRestClient() {
        super(BASE_URI);
    }

    public void login(String username, String password) {
        ValidatableResponse response = requestSpec()
            .param("username", username)
            .param("password", password)
            .post(LOGIN)
            .then()
            .statusCode(SC_OK);

        Map<String, String> cookies = new HashMap<>(response.extract().cookies());
        setUpCookies(cookies);
    }

}
