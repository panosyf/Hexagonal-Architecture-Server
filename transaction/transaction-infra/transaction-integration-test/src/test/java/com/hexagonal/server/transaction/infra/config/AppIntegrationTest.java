package com.hexagonal.server.transaction.infra.config;

import com.hexagonal.server.shared.kernel.testing.config.AbstractIntegrationTest;
import com.hexagonal.server.transaction.core.domain.service.driven.TransactionRepositoryPort;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;

public class AppIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    protected TransactionRepositoryPort transactionRepositoryPort;

    @AfterEach
    protected void cleanupRepositories() {
        transactionRepositoryPort.deleteAll();
    }

}
