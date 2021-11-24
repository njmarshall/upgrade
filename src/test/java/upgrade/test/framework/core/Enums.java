package upgrade.test.framework.core;

public class Enums {

    public enum HttpStatusCode {
        CONTINUE(100, "continue"),
        SWITCHING_PROTOCOL(101, "switching protocols"),
        PROCESSING(102, "processing"),

        OK(200, "ok"),
        CREATED(201, "created"),
        ACCEPTED(202, "accepted"),
        NON_AUTHORITATIVE_INFO(203, "non-authoritative information"),
        NO_CONTENT(204, "no content"),
        RESET_CONTENT(205, "reset content"),
        PARTIAL_CONTENT(206, "partial content"),
        MULTI_STATUS(207, "multi-status (webdav; rfc 4918"),

        USE_PROXY(305, "use proxy (since http/1.1)"),
        SWITCH_PROXY(306, "switch proxy"),

        BAD_REQUEST(400, "bad request"),
        UNAUTHORIZED(401, "unauthorized"),
        PAYMENT_REQUIRED(402, "payment required"),
        FORBIDDEN(403, "forbidden"),
        NOT_FOUND(404, "not found"),
        METHOD_NOT_ALLOWED(405, "method not allowed"),
        NOT_ACCEPTABLE(406, "not acceptable"),
        PROXY_AUTHENTICATION_REQUIRED(407, "proxy authentication required"),
        REQUEST_TIMEOUT(408, "request timeout"),
        CONFLICT(409, "conflict"),

        INTERNAL_SERVER_ERROR(500, "internal server error"),
        NOT_IMPLEMENTS(501, "not implemented"),
        BAD_GATEWAY(502, "bad gateway"),
        SERVICE_UNAVAILABLE(503, "service unavailable"),
        GATEWAY_TIMEOUT(504, "gateway timeout"),
        HTTP_VERSION_NOT_SUPPORTED(505, "http version not supported"),
        variant_also_negotiates(506, "variant also negotiates (rfc 2295)"),
        INSUFFICIENT_STORAGE(507, "insufficient storage (webdav; rfc 4918)"),
        LOOP_DETECTED(508, "loop detected (webdav; rfc 5842)"),
        BANDWIDTH_LIMIT_EXCEEDED(509, "bandwidth limit exceeded (apache bw/limited extension)"),
        NOT_EXTEND(510, "not extended (rfc 2774)"),
        NETWORK_AUTHENTICATION_REQUIRED(511, "network authentication required (rfc 6585)"),
        CONNECTION_TIMED_OUT(522, "connection timed out"),
        PROXY_DECLINED_REQUEST(523, "proxy declined request"),
        TIMEOUT_OCCURRED(524, "a timeout occurred");

        private int code;
        private String desc;

        HttpStatusCode(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }
}
