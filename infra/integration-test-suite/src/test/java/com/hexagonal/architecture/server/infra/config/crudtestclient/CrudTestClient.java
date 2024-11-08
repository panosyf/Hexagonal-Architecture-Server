package com.hexagonal.architecture.server.infra.config.crudtestclient;

import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.RequestBodySpec;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;
import reactor.core.publisher.Mono;

import static com.hexagonal.architecture.server.infra.common.constants.Endpoints.LOCALHOST_URL;
import static com.hexagonal.architecture.server.infra.common.helpers.EndpointHelper.generateUri;

public class CrudTestClient {

    private final WebTestClient webTestClient;
    private final String url = LOCALHOST_URL;
    private final HttpHeaders httpHeaders = new HttpHeaders();
    @LocalServerPort
    private int port;

    public CrudTestClient(WebTestClient webTestClient) {
        this.webTestClient = webTestClient;
    }

    public ResponseSpec execute(HttpMethod httpMethod, String uri) {
        return generateResponseRequest(httpMethod, url, port, uri, httpHeaders);
    }

    public ResponseSpec execute(HttpMethod httpMethod, String uri, HttpHeaders httpHeaders) {
        return generateResponseRequest(httpMethod, url, port, uri, httpHeaders);
    }

    public ResponseSpec execute(HttpMethod httpMethod, String uri, Object body) {
        return generateResponseRequest(httpMethod, url, port, uri, httpHeaders, body);
    }

    public ResponseSpec execute(HttpMethod httpMethod, String uri, HttpHeaders httpHeaders, Object body) {
        return generateResponseRequest(httpMethod, url, port, uri, httpHeaders, body);
    }

    public ResponseSpec execute(HttpMethod httpMethod, int port, String uri, HttpHeaders httpHeaders, Object body) {
        return generateResponseRequest(httpMethod, url, port, uri, httpHeaders, body);
    }

    public ResponseSpec execute(HttpMethod httpMethod, String url, int port, String uri, HttpHeaders httpHeaders, Object body) {
        return generateResponseRequest(httpMethod, url, port, uri, httpHeaders, body);
    }

    private RequestBodySpec generateCommonRequestBodySpec(HttpMethod httpMethod, String url, int port, String uri, HttpHeaders httpHeaders) {
        return webTestClient
                .method(httpMethod)
                .uri(generateUri(url, port, uri))
                .headers(headers -> headers.addAll(httpHeaders));
    }

    private ResponseSpec generateResponseRequest(HttpMethod httpMethod, String url, int port, String uri, HttpHeaders httpHeaders) {
        return generateCommonRequestBodySpec(httpMethod, url, port, uri, httpHeaders)
                .exchange();
    }

    private ResponseSpec generateResponseRequest(HttpMethod httpMethod, String url, int port, String uri, HttpHeaders httpHeaders, Object body) {
        if (HttpMethod.GET.equals(httpMethod) || HttpMethod.DELETE.equals(httpMethod)) {
            throw new IllegalArgumentException(httpMethod.name() + "cannot have a body");
        }
        return generateCommonRequestBodySpec(httpMethod, url, port, uri, httpHeaders)
                .body(Mono.just(body), body.getClass())
                .exchange();
    }

}
