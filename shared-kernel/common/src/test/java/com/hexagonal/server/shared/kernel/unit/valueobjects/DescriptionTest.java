package com.hexagonal.server.shared.kernel.unit.valueobjects;

import com.hexagonal.server.shared.kernel.valueobjects.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DescriptionTest {

    @Test
    void emptyDescriptionTest() {
        assertThat(Description.emptyDescription().getValue()).isEqualTo("");
    }

    @ParameterizedTest
    @MethodSource("nullOrBlankDescriptionHandlingTestArguments")
    void nullOrBlankDescriptionHandlingTest(String value) {
        assertThat(Description.valueOf(value).equals(Description.emptyDescription())).isTrue();
        assertThat(Description.valueOf(value).getValue()).isEqualTo("");
    }

    private static Stream<Arguments> nullOrBlankDescriptionHandlingTestArguments() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("         "),
                Arguments.of((Object) null)
        );
    }

}
