package upgrade.test.loanapp.api.requests;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import upgrade.test.framework.api.RequestBase;

import java.util.ArrayList;
import java.util.List;

public class LoadAppRequest extends RequestBase {

    /**
     *  Create API instance for a given user to access the URL
     *
     * @param endpoint - main URL for the loadApp system
     */
    public LoadAppRequest(String endpoint){
        super(endpoint);
    }

    public Response getLoadAppId(String UuId, boolean skipSideEffects) {
        return getLoadAppId(UuId, skipSideEffects, ContentType.JSON.toString());
    }

    public Response getLoadAppId(String UuId, boolean skipSideEffects, String contentType) {

        List<Header> newHeaders = new ArrayList<Header>();
        newHeaders.add(new Header("x-cf-source-id", "coding-challenge"));
        newHeaders.add(new Header("x-cf-corr-id", UuId));
        Headers headers = new Headers(newHeaders);

        JSONObject requestParams = new JSONObject();
        requestParams.put("loanAppUuid", UuId);
        requestParams.put("skipSideEffects", skipSideEffects);

        return post(
                requestParams.toJSONString(),
                headers,
                contentType);
    }

}
