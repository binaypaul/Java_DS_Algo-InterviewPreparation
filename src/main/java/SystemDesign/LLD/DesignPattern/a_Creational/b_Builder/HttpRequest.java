package SystemDesign.LLD.DesignPattern.a_Creational.b_Builder;

import java.util.*;

public class HttpRequest {
    private String url;
    private String method;
    private Map<String, String> headers;
    private String body;

    private HttpRequest() {}

    public static class Builder {
        private HttpRequest request = new HttpRequest();

        public Builder url(String url) {
            request.url = url;
            return this;
        }

        public Builder method(String method) {
            request.method = method;
            return this;
        }

        public Builder header(String key, String value) {
            if (request.headers == null) {
                request.headers = new HashMap<>();
            }
            request.headers.put(key, value);
            return this;
        }

        public Builder body(String body) {
            request.body = body;
            return this;
        }

        public HttpRequest build() {
            // Validate required fields
            if (request.url == null) {
                throw new IllegalStateException("URL is required");
            }
            return request;
        }
    }
}