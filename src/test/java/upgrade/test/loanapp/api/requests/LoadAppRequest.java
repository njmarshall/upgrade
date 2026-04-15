package upgrade.test.loanapp.api.requests;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import upgrade.test.framework.api.RequestBase;

import java.util.ArrayList;
import java.util.List;

/**
 * API request class for the Loan Application resumption endpoint.
 * Builds and sends POST requests with the required Credify headers.
 */
public class LoadAppRequest extends RequestBase {

    /**
     * @param endpoint the full URL for the loan app resumption API
     */
    public LoadAppRequest(String endpoint) {
        super(endpoint);
    }

    public Response getLoadAppId(String uuid, boolean skipSideEffects) {
        return getLoadAppId(uuid, skipSideEffects, ContentType.JSON.toString());
    }

    public Response getLoadAppId(String uuid, boolean skipSideEffects, String contentType) {
        List<Header> headerList = new ArrayList<>();
        headerList.add(new Header("x-cf-source-id", "coding-challenge"));
        headerList.add(new Header("x-cf-corr-id", uuid));
        Headers headers = new Headers(headerList);

        JSONObject requestParams = new JSONObject();
        requestParams.put("loanAppUuid", uuid);
        requestParams.put("skipSideEffects", skipSideEffects);

        return post(requestParams.toJSONString(), headers, contentType);
    }
}