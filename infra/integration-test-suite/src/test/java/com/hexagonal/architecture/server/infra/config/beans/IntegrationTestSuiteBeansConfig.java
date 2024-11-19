package com.hexagonal.architecture.server.infra.config.beans;

import com.hexagonal.architecture.server.infra.config.crudtestclient.CrudTestClient;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.web.reactive.server.WebTestClient;
// TODO MOVE TO SHARED KERNEL
@TestConfiguration
public class IntegrationTestSuiteBeansConfig {

    private final WebTestClient webTestClient;

    public IntegrationTestSuiteBeansConfig(WebTestClient webTestClient) {
        this.webTestClient = webTestClient;
    }

    @Lazy
    @Bean
    public CrudTestClient crudTestClient() {
        return new CrudTestClient(webTestClient);
    }

}
