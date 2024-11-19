package com.hexagonal.architecture.server.shared.kernel.unit.valueobjects;

import com.hexagonal.architecture.server.core.domain.valueobjects.Email;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EmailTest {

    @Test
    void valueOfTest() {
        String mail = "test@gmail.com";
        assertThat(mail)
                .isEqualTo(Email.valueOf(mail).getValue())
                .isEqualTo(Email.valueOf("test", "gmail", "com").getValue());
    }


    @ParameterizedTest
    @MethodSource("validateValueTestArguments")
    void validateValueTest(String value) {
        assertThatThrownBy(() -> Email.valueOf(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Email value cannot be null or blank");
    }

    private static Stream<Arguments> validateValueTestArguments() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("         "),
                Arguments.of((Object) null)
        );
    }

    @ParameterizedTest
    @MethodSource("validateInputsTestArguments")
    void validateInputsTest(String name, String mailServer, String domain) {
        assertThatThrownBy(() -> Email.valueOf(name, mailServer, domain))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> validateInputsTestArguments() {
        return Stream.of(
                Arguments.of("", "       ", null),
                Arguments.of("Gsgs", "rgh", ""),
                Arguments.of(null, "gwwe", "WGEW")
        );
    }

}
