package com.hexagonal.server.shared.kernel.testing.config.beans;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.hexagonal.server.shared.kernel.testing.config.crudtestclient.CrudTestClient;

@TestConfiguration
public class CommonIntegrationTestBeansConfig {

    private final WebTestClient webTestClient;

    public CommonIntegrationTestBeansConfig(WebTestClient webTestClient) {
        this.webTestClient = webTestClient;
    }

    @Lazy
    @Bean
    public CrudTestClient crudTestClient() {
        return new CrudTestClient(webTestClient);
    }

}
