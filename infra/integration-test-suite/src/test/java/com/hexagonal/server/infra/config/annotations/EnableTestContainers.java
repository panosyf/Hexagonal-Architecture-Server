package com.hexagonal.server.infra.config.annotations;

import com.hexagonal.server.infra.config.testcontainers.TestContainersInitializer;
import org.springframework.test.context.ContextConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
// TODO MOVE TO SHARED KERNEL
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(initializers = TestContainersInitializer.class)
public @interface EnableTestContainers {
}
