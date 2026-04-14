package upgrade.test.framework.api;

import com.google.common.base.Strings;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import upgrade.test.framework.api.utils.HttpUtils;

import java.net.URL;

public class RequestBase {

    private final URL url;
    private String authUser;
    private String authPassword;

    public RequestBase(String aUrl) {
        this.url = HttpUtils.getURLfromString(aUrl);
    }

    /**
     * Configure HTTP Basic Authentication for subsequent requests.
     */
    protected void basicAuth(String user, String password) {
        this.authUser = user;
        this.authPassword = password;
    }

    /**
     * Execute a POST request with the given payload, headers, and content type.
     *
     * @param payLoad     request body (must not be null or empty)
     * @param headers     optional HTTP headers
     * @param contentType MIME type of the request body
     * @return the RestAssured Response
     */
    protected Response post(String payLoad, Headers headers, String contentType) {
        if (payLoad == null) {
            throw new IllegalArgumentException("post: payLoad argument cannot be null");
        }
        // Fix: use isEmpty() instead of == "" (reference comparison is unreliable)
        if (payLoad.trim().isEmpty()) {
            throw new IllegalArgumentException("post: payLoad argument cannot be empty");
        }

        RequestSpecification request = RestAssured.given();

        if (!Strings.isNullOrEmpty(authUser)) {
            request = request.auth().preemptive().basic(authUser, authPassword);
        }

        if (headers != null) {
            request = request.headers(headers);
        }

        if (!Strings.isNullOrEmpty(contentType)) {
            request = request.contentType(contentType);
        }

        Response response = request
                .body(payLoad)
                .when()
                .post(url.toExternalForm())
                .thenReturn();

        HttpUtils.LogResponseEverything(response);
        return response;
    }
}