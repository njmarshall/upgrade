package upgrade.test.framework.api.utils;

import io.restassured.response.Response;

import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtils {

    public static URL getURLfromString(String aString){
        try {
            return new URL(aString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException(
                    String.format(
                            "URL %s is not correctly formatted",
                            aString));
        }
    }

    public static void LogResponseEverything(Response response) {
        LogResponseStatus(response);
        LogResponseHeaders(response);
        LogResponseBody(response);
    }

    public static void LogResponseStatus(Response response) {
        response.then().log().status();
    }

    public static void LogResponseHeaders(Response response) {
        response.then().log().headers();
    }

    public static void LogResponseBody(Response response) {
        response.then().log().body();
    }

}