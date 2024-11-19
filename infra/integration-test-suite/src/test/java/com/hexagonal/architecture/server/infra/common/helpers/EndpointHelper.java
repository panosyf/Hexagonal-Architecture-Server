package com.hexagonal.architecture.server.infra.common.helpers;
// TODO MOVE TO SHARED KERNEL
public class EndpointHelper {

    public static String generateUri(String url, int port, String uri) {
        return url + port + uri;
    }

}
