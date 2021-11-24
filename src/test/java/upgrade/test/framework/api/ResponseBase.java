package upgrade.test.framework.api;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class ResponseBase {

    private final int statusCode;
    private final String body;
    private final Map<String,String> responseHeaders;
    private final String contentType;

    public ResponseBase(Response response) {
        this.statusCode = response.getStatusCode();

        this.responseHeaders = new HashMap<>();
        Headers headers = response.getHeaders();
        for(Header header: headers){
            responseHeaders.put(header.getName(), header.getValue());
        }
        this.contentType = response.getContentType();
        this.body = response.body().asString();
    }

    public int getStatusCode(){
        return statusCode;
    }

    public String body(){
        return body;
    }

    public Map<String,String> getHeaders(){
        return responseHeaders;
    }

    public String getContentType() {
        return contentType;
    }

}
