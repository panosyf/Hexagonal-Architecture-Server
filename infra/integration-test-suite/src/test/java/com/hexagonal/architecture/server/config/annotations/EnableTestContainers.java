package com.hexagonal.architecture.server.config.annotations;

import com.hexagonal.architecture.server.config.testcontainers.TestContainersInitializer;
import org.springframework.test.context.ContextConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(initializers = TestContainersInitializer.class)
public @interface EnableTestContainers {
}
