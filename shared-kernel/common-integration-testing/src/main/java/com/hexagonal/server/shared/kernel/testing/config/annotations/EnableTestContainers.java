package com.hexagonal.server.shared.kernel.testing.config.annotations;

import org.springframework.test.context.ContextConfiguration;

import com.hexagonal.server.shared.kernel.testing.config.testcontainers.TestContainersInitializer;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(initializers = TestContainersInitializer.class)
public @interface EnableTestContainers {
}
