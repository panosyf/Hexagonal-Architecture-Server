package com.hexagonal.server.infra.config;

import com.hexagonal.server.infra.IntegrationTestSuite;
import com.hexagonal.server.infra.config.annotations.EnableTestContainers;
import com.hexagonal.server.infra.config.beans.IntegrationTestSuiteBeansConfig;
import com.hexagonal.server.infra.config.crudtestclient.CrudTestClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// TODO MOVE TO SHARED KERNEL
@ExtendWith(SpringExtension.class)
@SpringBootTest(
        classes = IntegrationTestSuite.class,
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
