package upgrade.test.loanapp.api.requests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import upgrade.test.framework.api.RequestBase;

import java.util.ArrayList;
import java.util.List;

/**
 * API request class for the Loan Application resumption endpoint.
 * Builds and sends POST requests with the required Credify headers.
 */
public class LoadAppRequest extends RequestBase {

    private static final ObjectMapper mapper = new ObjectMapper();

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

        try {
            ObjectNode payload = mapper.createObjectNode();
            payload.put("loanAppUuid", uuid);
            payload.put("skipSideEffects", skipSideEffects);
            return post(mapper.writeValueAsString(payload), headers, contentType);
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize request payload", e);
        }
    }
}