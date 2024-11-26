package com.hexagonal.server.account.infra.config;

import com.hexagonal.server.account.core.domain.service.driven.AccountRepositoryPort;
import com.hexagonal.server.shared.kernel.testing.config.AbstractIntegrationTest;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;

public class AppIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    protected AccountRepositoryPort accountRepositoryPort;

    @AfterEach
    protected void cleanupRepositories() {
        accountRepositoryPort.deleteAll();
    }

}
