package in.reqres.testing.utils.resource;

import in.reqres.testing.utils.constants.Endpoints;

public enum WebServiceEndpoints {

    URI(Endpoints.URL_USERS);

    private final String url;

    WebServiceEndpoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
