package com.hexagonal.server.transaction.infra.config;

import com.hexagonal.server.shared.kernel.testing.config.AbstractIntegrationTest;
import com.hexagonal.server.transaction.application.service.apis.AccountApi;
import com.hexagonal.server.transaction.core.domain.service.driven.TransactionRepositoryPort;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

public class CommonIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    protected TransactionRepositoryPort transactionRepositoryPort;

    @MockBean
    protected AccountApi accountApi;

    @AfterEach
    protected void cleanupRepositories() {
        transactionRepositoryPort.deleteAll();
    }

}
