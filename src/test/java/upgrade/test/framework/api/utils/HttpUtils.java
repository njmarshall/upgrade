package upgrade.test.framework.api.utils;

import io.restassured.response.Response;

import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtils {

    private HttpUtils() {
        // Utility class — not instantiable
    }

    public static URL getURLfromString(String aString) {
        try {
            return new URL(aString);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(
                    String.format("URL '%s' is not correctly formatted", aString), e);
        }
    }

    public static void logResponseEverything(Response response) {
        logResponseStatus(response);
        logResponseHeaders(response);
        logResponseBody(response);
    }

    public static void logResponseStatus(Response response) {
        response.then().log().status();
    }

    public static void logResponseHeaders(Response response) {
        response.then().log().headers();
    }

    public static void logResponseBody(Response response) {
        response.then().log().body();
    }
}