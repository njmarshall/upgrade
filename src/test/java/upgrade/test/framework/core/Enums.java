package upgrade.test.framework.core;

/**
 * Domain enumerations for the test framework.
 */
public class Enums {

    private Enums() { }

    /**
     * Standard HTTP status codes used in API test assertions.
     * Covers 1xx informational, 2xx success, 3xx redirect, 4xx client error,
     * and 5xx server error ranges relevant to the Upgrade loan API.
     */
    public enum HttpStatusCode {

        // 1xx Informational
        CONTINUE(100, "Continue"),
        SWITCHING_PROTOCOLS(101, "Switching Protocols"),
        PROCESSING(102, "Processing"),

        // 2xx Success
        OK(200, "OK"),
        CREATED(201, "Created"),
        ACCEPTED(202, "Accepted"),
        NO_CONTENT(204, "No Content"),
        PARTIAL_CONTENT(206, "Partial Content"),

        // 3xx Redirection
        MOVED_PERMANENTLY(301, "Moved Permanently"),
        FOUND(302, "Found"),
        NOT_MODIFIED(304, "Not Modified"),

        // 4xx Client Errors
        BAD_REQUEST(400, "Bad Request"),
        UNAUTHORIZED(401, "Unauthorized"),
        FORBIDDEN(403, "Forbidden"),
        NOT_FOUND(404, "Not Found"),
        METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
        CONFLICT(409, "Conflict"),
        UNPROCESSABLE_ENTITY(422, "Unprocessable Entity"),
        TOO_MANY_REQUESTS(429, "Too Many Requests"),

        // 5xx Server Errors
        INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
        BAD_GATEWAY(502, "Bad Gateway"),
        SERVICE_UNAVAILABLE(503, "Service Unavailable"),
        GATEWAY_TIMEOUT(504, "Gateway Timeout");

        private final int code;
        private final String description;

        HttpStatusCode(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public int getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }

        /**
         * Looks up an HttpStatusCode by its numeric code.
         * @throws IllegalArgumentException if no matching code is found
         */
        public static HttpStatusCode fromCode(int code) {
            for (HttpStatusCode status : values()) {
                if (status.code == code) return status;
            }
            throw new IllegalArgumentException("Unknown HTTP status code: " + code);
        }

        @Override
        public String toString() {
            return code + " " + description;
        }
    }
}
