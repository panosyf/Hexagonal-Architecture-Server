package com.hexagonal.architecture.server.integration.test.suite.config.beans;

import com.hexagonal.architecture.server.integration.test.suite.config.httptestclient.RestTestClient;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.web.reactive.server.WebTestClient;

@TestConfiguration
public class IntegrationTestSuiteBeansConfig {

    private final WebTestClient webTestClient;

    public IntegrationTestSuiteBeansConfig(WebTestClient webTestClient) {
        this.webTestClient = webTestClient;
    }

    @Lazy
    @Bean
    public RestTestClient restTestClient() {
        return new RestTestClient(webTestClient);
    }

}
