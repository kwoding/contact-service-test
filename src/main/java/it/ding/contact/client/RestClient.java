package it.ding.contact.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.internal.ResponseParserRegistrar;
import io.restassured.internal.ResponseSpecificationImpl;
import io.restassured.internal.TestSpecificationImpl;
import io.restassured.internal.log.LogRepository;
import io.restassured.specification.RequestSpecification;
import it.ding.contact.util.GlobalProperties;
import java.util.NoSuchElementException;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.config.HttpClientConfig.httpClientConfig;

public class RestClient {

    private GlobalProperties globalProperties = GlobalProperties.getInstance();
    private static final String CONNECTION_MANAGER_TIMEOUT = "CONNECTION_MANAGER_TIMEOUT";
    private static final int TIMEOUT_VALUE = 10000;
    private static final String PROPERTY_LOG_ALL_REQUESTS_RESPONSES = "log.all.requests.responses";

    private URI baseURI = null;
    private RestAssuredConfig restAssuredConfig;
    private String initialPath = "";
    private String version;

    private static Map<String, String> cookiesJar = new LinkedHashMap<>();
    private final ResponseParserRegistrar responseParserRegistrar = new ResponseParserRegistrar();

    RestClient(String baseUri) {
        setBaseUri(baseUri);
    }

    RestClient(String baseUri, String version) {
        setBaseUri(baseUri);
        this.version = version;
    }

    public RestClient setInitialPath(String initialPath) {
        this.initialPath = initialPath;
        return this;
    }

    public RestAssuredConfig getRestAssuredConfig() {
        return restAssuredConfig;
    }

    public String getInitialPath() {
        return initialPath;
    }

    public String getPath(String endpoint) {
        return version + endpoint;
    }

    public String getBaseURIWithoutPort() {
        String baseAPI;

        URI uri;
        try {
            uri = new URIBuilder().setScheme(baseURI.getScheme()).setHost(baseURI.getHost()).build();
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("An error occurred while constructing base uri without port", e);
        }
        baseAPI = uri.toString();
        return baseAPI;
    }

    public RequestSpecification requestSpec() {
        LogRepository logRepository = new LogRepository();
        restAssuredConfig = RestAssuredConfig.config()
            .objectMapperConfig(new ObjectMapperConfig().jackson2ObjectMapperFactory(
                (aClass, s) -> new ObjectMapper().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            ))
            .logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails())
            .httpClient(httpClientConfig().setParam(CONNECTION_MANAGER_TIMEOUT, TIMEOUT_VALUE));

        RequestSpecification requestSpec = new TestSpecificationImpl(
            new RequestSpecificationImpl(getBaseURI().toString(),
                getBaseURI().getPort(), getInitialPath(), RestAssured.DEFAULT_AUTH, Collections.emptyList(), null,
                RestAssured.DEFAULT_URL_ENCODING_ENABLED, restAssuredConfig, logRepository, null),
            new ResponseSpecificationImpl(RestAssured.DEFAULT_BODY_ROOT_PATH, null, this.responseParserRegistrar,
                restAssuredConfig, logRepository)).
            getRequestSpecification();

        setLoggingFilters(requestSpec);

        requestSpec.queryParam("_csrf", getCookies().get("XSRF-TOKEN"));

        requestSpec.cookies(getCookies());

        return requestSpec;
    }


    protected static void setUpCookies(Map<String, String> cookies) {
        cookiesJar.putAll(cookies);
    }

    private void setBaseUri(String baseUri) {
        try {
            this.baseURI = new URI(baseUri);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("An error occurred while creating RestClient, 'baseUri' is incorrect", e);
        }
    }

    private Map<String, String> getCookies() {
        return cookiesJar;
    }

    private URI getBaseURI() {
        return baseURI;
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
