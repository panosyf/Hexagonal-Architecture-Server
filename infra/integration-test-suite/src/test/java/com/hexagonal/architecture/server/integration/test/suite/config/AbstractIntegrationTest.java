package com.hexagonal.architecture.server.integration.test.suite.config;

import com.hexagonal.architecture.server.HexagonalArchitectureServerApplication;
import com.hexagonal.architecture.server.core.domain.service.ports.driven.AccountRepositoryPort;
import com.hexagonal.architecture.server.core.domain.service.ports.driven.TransactionRepositoryPort;
import com.hexagonal.architecture.server.integration.test.suite.config.annotations.EnableTestContainers;
import com.hexagonal.architecture.server.integration.test.suite.config.beans.IntegrationTestSuiteBeansConfig;
import com.hexagonal.architecture.server.integration.test.suite.config.httptestclient.RestTestClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        classes = HexagonalArchitectureServerApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@EnableTestContainers
@Import(IntegrationTestSuiteBeansConfig.class)
public abstract class AbstractIntegrationTest {

    @Autowired
    protected RestTestClient restTestClient;

    @Autowired
    protected AccountRepositoryPort accountRepositoryPort;

    @Autowired
    protected TransactionRepositoryPort transactionRepositoryPort;

    @AfterEach
    void cleanupRepositories() {
        accountRepositoryPort.deleteAll();
        transactionRepositoryPort.deleteAll();
    }

}
