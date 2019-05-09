package it.ding.contact.client;

import static it.ding.contact.data.CommonData.PROPERTY_BASE_URI;
import static org.apache.http.HttpStatus.SC_OK;

import io.restassured.response.ValidatableResponse;
import it.ding.contact.util.GlobalProperties;
import java.util.HashMap;
import java.util.Map;

public class LoginRestClient extends RestClient {

    private static final GlobalProperties globalProperties = GlobalProperties.getInstance();
    private static final String BASE_URI = globalProperties.getString(PROPERTY_BASE_URI);
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
