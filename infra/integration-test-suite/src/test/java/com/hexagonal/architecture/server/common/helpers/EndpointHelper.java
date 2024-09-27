package com.hexagonal.architecture.server.common.helpers;

public class EndpointHelper {

    public static String generateUri(String url, int port, String uri) {
        return url + port + uri;
    }

}
