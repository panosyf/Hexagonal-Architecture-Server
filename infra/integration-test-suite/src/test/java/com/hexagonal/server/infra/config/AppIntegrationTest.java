package com.hexagonal.server.infra.config;

import com.hexagonal.server.core.domain.service.ports.driven.AccountRepositoryPort;
import com.hexagonal.server.core.domain.service.ports.driven.TransactionRepositoryPort;

import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;

import com.hexagonal.server.shared.kernel.testing.config.AbstractIntegrationTest;

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
