package com.hexagonal.server.config;

import com.hexagonal.server.shared.kernel.testing.config.AbstractIntegrationTest;
import com.hexagonal.server.transaction.core.domain.service.driven.AccountRepositoryPort;
import com.hexagonal.server.transaction.core.domain.service.driven.TransactionRepositoryPort;
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