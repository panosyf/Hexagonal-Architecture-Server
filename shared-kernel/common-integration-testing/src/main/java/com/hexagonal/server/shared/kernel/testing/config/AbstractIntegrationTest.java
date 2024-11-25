package com.hexagonal.server.shared.kernel.testing.config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.hexagonal.server.shared.kernel.testing.config.annotations.EnableTestContainers;
import com.hexagonal.server.shared.kernel.testing.config.beans.IntegrationTestSuiteBeansConfig;
import com.hexagonal.server.shared.kernel.testing.config.crudtestclient.CrudTestClient;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
//        classes = IntegrationTestSuite.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@EnableTestContainers
@Import(IntegrationTestSuiteBeansConfig.class)
public abstract class AbstractIntegrationTest {

    @Autowired
    protected CrudTestClient crudTestClient;

    @AfterEach
    protected abstract void cleanupRepositories();

}
