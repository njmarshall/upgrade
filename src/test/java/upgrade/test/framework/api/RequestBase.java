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

    /*
        Authentication is set using
        given().
            auth().preemptive().basic(authUser, authPassword).
     */
    protected void basicAuth(String user, String password) {
        this.authUser = user;
        this.authPassword = password;
    }

    protected Response post(String payLoad, Headers headers, String contentType) {
        RequestSpecification request = RestAssured.given();

        if(payLoad == null) {
            throw new NullPointerException("post: payLoad argument cannot be null");
        }

        if (payLoad.trim() == "") {
            throw new ArithmeticException("post: payLoad argument cannot be empty");
        }

        if (headers != null) {
            request = request.headers(headers);
        }

        if (!Strings.isNullOrEmpty(contentType)) {
            request = request.contentType(contentType);
        }

        Response response =
            request.
                body(payLoad).
            when().
                post(url.toExternalForm()).andReturn().
            thenReturn();

        HttpUtils.LogResponseEverything(response);
        return response;
    }
}
