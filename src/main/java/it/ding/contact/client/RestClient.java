package it.ding.contact.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.internal.ResponseParserRegistrar;
import io.restassured.specification.RequestSpecification;
import it.ding.contact.util.GlobalProperties;
import java.util.NoSuchElementException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.config.HttpClientConfig.httpClientConfig;
import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;

public class RestClient {

    private static final GlobalProperties globalProperties = GlobalProperties.getInstance();
    private static final String CONNECTION_MANAGER_TIMEOUT = "http.connection.timeout";
    private static final int TIMEOUT_IN_MILLISECONDS = 10000;
    private static final String PROPERTY_LOG_ALL_REQUESTS_RESPONSES = "log.all.requests.responses";
    private URI baseUri = null;
    private String basePath = "";

    private static Map<String, String> cookiesJar = new LinkedHashMap<>();

    RestClient(String baseUri) {
        setBaseUri(baseUri);
    }

    RestClient(String baseUri, String basePath) {
        setBaseUri(baseUri);
        setBasePath(basePath);
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public RequestSpecification requestSpec() {
        RestAssuredConfig config = RestAssured.config()
            .objectMapperConfig(objectMapperConfig()
                .jackson2ObjectMapperFactory((cls, charset) -> new ObjectMapper()
                    .registerModule(new JavaTimeModule())
                    .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)))
            .httpClient(httpClientConfig().setParam(CONNECTION_MANAGER_TIMEOUT, TIMEOUT_IN_MILLISECONDS));

        RequestSpecification requestSpecification = RestAssured.with()
            .relaxedHTTPSValidation()
            .config(config)
            .baseUri(getBaseUri().toString())
            .basePath(getBasePath());

        setLoggingFilters(requestSpecification);

        requestSpecification.cookies(getCookies());

        return requestSpecification;
    }

    protected static void setUpCookies(Map<String, String> cookies) {
        cookiesJar.putAll(cookies);
    }

    private void setBaseUri(String baseUri) {
        try {
            this.baseUri = new URI(baseUri);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("An error occurred while creating RestClient, 'baseUri' is incorrect", e);
        }
    }

    private Map<String, String> getCookies() {
        return cookiesJar;
    }

    private URI getBaseUri() {
        return baseUri;
    }

    private void setLoggingFilters(RequestSpecification requestSpec) {
        boolean logAllRequestsResponses;
        try {
            logAllRequestsResponses = globalProperties.getBoolean(PROPERTY_LOG_ALL_REQUESTS_RESPONSES);
        } catch (NoSuchElementException e) {
            logAllRequestsResponses = false;
        }

        if (logAllRequestsResponses) {
            requestSpec
                .filter(new ResponseLoggingFilter())
                .filter(new RequestLoggingFilter());
        }
    }
}
