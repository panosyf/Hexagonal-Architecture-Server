package com.hexagonal.server.infra.config.testcontainers;

import com.hexagonal.server.core.domain.service.ports.driven.AccountRepositoryPort;
import com.hexagonal.server.core.domain.service.ports.driven.TransactionRepositoryPort;
import com.hexagonal.server.infra.config.AbstractIntegrationTest;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;

public class AppIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    protected AccountRepositoryPort accountRepositoryPort;

    @Autowired
    protected TransactionRepositoryPort transactionRepositoryPort;

    @AfterEach
    protected void cleanupRepositories() {
        accountRepositoryPort.deleteAll();
        transactionRepositoryPort.deleteAll();
    }

}
