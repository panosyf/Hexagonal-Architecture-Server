package com.hexagonal.server.shared.kernel.testing.config.requesttestclient;

import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.RequestBodySpec;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;
import reactor.core.publisher.Mono;

import com.hexagonal.server.shared.kernel.testing.common.helpers.EndpointHelper;

import static com.hexagonal.server.shared.kernel.testing.common.constants.Endpoints.LOCALHOST_URL;

public class RequestTestClient {

    private final WebTestClient webTestClient;
    private final String url = LOCALHOST_URL;
    private final HttpHeaders httpHeaders = new HttpHeaders();
    @LocalServerPort
    private int port;

    public RequestTestClient(WebTestClient webTestClient) {
        this.webTestClient = webTestClient;
    }

    public ResponseSpec get(String uri) {
        return generateResponseRequest(HttpMethod.GET, url, port, uri, httpHeaders);
    }

    public ResponseSpec get(String uri, HttpHeaders httpHeaders) {
        return generateResponseRequest(HttpMethod.GET, url, port, uri, httpHeaders);
    }

    public ResponseSpec delete(String uri) {
        return generateResponseRequest(HttpMethod.DELETE, url, port, uri, httpHeaders);
    }

    public ResponseSpec delete(String uri, HttpHeaders httpHeaders) {
        return generateResponseRequest(HttpMethod.DELETE, url, port, uri, httpHeaders);
    }

    public ResponseSpec post(String uri, Object body) {
        return generateResponseRequest(HttpMethod.POST, url, port, uri, httpHeaders, body);
    }

    public ResponseSpec post(String uri, HttpHeaders httpHeaders, Object body) {
        return generateResponseRequest(HttpMethod.POST, url, port, uri, httpHeaders, body);
    }

    public ResponseSpec post(int port, String uri, HttpHeaders httpHeaders, Object body) {
        return generateResponseRequest(HttpMethod.POST, url, port, uri, httpHeaders, body);
    }

    public ResponseSpec post(String url, int port, String uri, HttpHeaders httpHeaders, Object body) {
        return generateResponseRequest(HttpMethod.POST, url, port, uri, httpHeaders, body);
    }

    public ResponseSpec put(String uri, Object body) {
        return generateResponseRequest(HttpMethod.PUT, url, port, uri, httpHeaders, body);
    }

    public ResponseSpec put(String uri, HttpHeaders httpHeaders, Object body) {
        return generateResponseRequest(HttpMethod.PUT, url, port, uri, httpHeaders, body);
    }

    public ResponseSpec put(int port, String uri, HttpHeaders httpHeaders, Object body) {
        return generateResponseRequest(HttpMethod.PUT, url, port, uri, httpHeaders, body);
    }

    public ResponseSpec put(String url, int port, String uri, HttpHeaders httpHeaders, Object body) {
        return generateResponseRequest(HttpMethod.PUT, url, port, uri, httpHeaders, body);
    }


    private RequestBodySpec generateCommonRequestBodySpec(HttpMethod httpMethod, String url, int port, String uri, HttpHeaders httpHeaders) {
        return webTestClient
                .method(httpMethod)
                .uri(EndpointHelper.generateUri(url, port, uri))
                .headers(headers -> headers.addAll(httpHeaders));
    }

    private ResponseSpec generateResponseRequest(HttpMethod httpMethod, String url, int port, String uri, HttpHeaders httpHeaders) {
        return generateCommonRequestBodySpec(httpMethod, url, port, uri, httpHeaders)
                .exchange();
    }

    private ResponseSpec generateResponseRequest(HttpMethod httpMethod, String url, int port, String uri, HttpHeaders httpHeaders, Object body) {
        return generateCommonRequestBodySpec(httpMethod, url, port, uri, httpHeaders)
                .body(Mono.just(body), body.getClass())
                .exchange();
    }

}
