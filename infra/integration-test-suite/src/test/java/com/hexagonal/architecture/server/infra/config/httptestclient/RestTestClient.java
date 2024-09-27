package com.hexagonal.architecture.server.infra.config.httptestclient;

import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;
import reactor.core.publisher.Mono;

import static com.hexagonal.architecture.server.infra.common.constants.Endpoints.LOCALHOST_URL;
import static com.hexagonal.architecture.server.infra.common.helpers.EndpointHelper.generateUri;

public class RestTestClient {

    private final WebTestClient webTestClient;
    private final String url = LOCALHOST_URL;
    private final HttpHeaders httpHeaders = new HttpHeaders();
    @LocalServerPort
    private int port;

    public RestTestClient(WebTestClient webTestClient) {
        this.webTestClient = webTestClient;
    }

    public ResponseSpec execute(HttpMethod httpMethod, String uri) {
        return webTestClient
                .method(httpMethod)
                .uri(generateUri(url, port, uri))
                .headers(headers -> headers.addAll(httpHeaders))
                .exchange();
    }

    public ResponseSpec execute(HttpMethod httpMethod, String uri, Object body) {
        return webTestClient
                .method(httpMethod)
                .uri(generateUri(url, port, uri))
                .headers(headers -> headers.addAll(httpHeaders))
                .body(Mono.just(body), body.getClass())
                .exchange();
    }

    public ResponseSpec execute(HttpMethod httpMethod, String uri, HttpHeaders httpHeaders) {
        return webTestClient
                .method(httpMethod)
                .uri(generateUri(url, port, uri))
                .headers(headers -> headers.addAll(httpHeaders))
                .exchange();
    }

    public ResponseSpec execute(HttpMethod httpMethod, String uri, HttpHeaders httpHeaders, Object body) {
        return webTestClient
                .method(httpMethod)
                .uri(generateUri(url, port, uri))
                .headers(headers -> headers.addAll(httpHeaders))
                .body(Mono.just(body), body.getClass())
                .exchange();
    }

    public ResponseSpec execute(HttpMethod httpMethod, int port, String uri, HttpHeaders httpHeaders, Object body) {
        return webTestClient
                .method(httpMethod)
                .uri(generateUri(url, port, uri))
                .headers(headers -> headers.addAll(httpHeaders))
                .body(Mono.just(body), body.getClass())
                .exchange();
    }

    public ResponseSpec execute(HttpMethod httpMethod, String url, int port, String uri, HttpHeaders httpHeaders, Object body) {
        return webTestClient
                .method(httpMethod)
                .uri(generateUri(url, port, uri))
                .headers(headers -> headers.addAll(httpHeaders))
                .body(Mono.just(body), body.getClass())
                .exchange();
    }

}
