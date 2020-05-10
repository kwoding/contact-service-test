package it.ding.contact.client;

import static it.ding.contact.data.CommonData.PROPERTY_BASE_URI;
import static org.apache.http.HttpStatus.SC_OK;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import it.ding.contact.util.GlobalProperties;
import java.util.HashMap;
import java.util.Map;

public class LoginRestClientV1 extends RestClient {

    private static final GlobalProperties globalProperties = GlobalProperties.getInstance();

    private static final String BASE_URI = globalProperties.getString(PROPERTY_BASE_URI);

    private static final String LOGIN = "/login";

    public LoginRestClientV1() {
        super(BASE_URI);
    }

    public Response login(String username, String password) {
        Response response = requestSpec()
            .param("username", username)
            .param("password", password)
            .post(LOGIN);

        Map<String, String> cookies = new HashMap<>(response.then().extract().cookies());
        setUpCookies(cookies);

        return response;
    }

}
