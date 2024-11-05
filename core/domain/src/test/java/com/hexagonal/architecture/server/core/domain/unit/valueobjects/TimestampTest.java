package com.hexagonal.architecture.server.core.domain.unit.valueobjects;

import com.hexagonal.architecture.server.core.domain.exceptions.utils.messages.ErrorMessageConstants;
import com.hexagonal.architecture.server.core.domain.valueobjects.Timestamp;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TimestampTest {

    private final Instant instant = Instant.parse("2024-05-05T16:00:00.600000000Z");
    private final Instant instantAfter = Instant.parse("2024-12-05T19:00:00.600000000Z");

    @Test
    void generateTest() {
        assertThat(instant)
                .isEqualTo(Timestamp.valueOf(instant).getTime());
        assertThat(Timestamp.now().getTime()).isInstanceOf(Instant.class);
    }

    @Test
    void validateValueOfTest() {
        assertThatThrownBy(() -> Timestamp.valueOf(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessageConstants.TIMESTAMP_CANNOT_BE_NULL);
    }

    @Test
    void  isBeforeTest() {
        assertThat(Timestamp.valueOf(instant)
                .isBefore(Timestamp.valueOf(instantAfter)))
                .isTrue();
    }

    @Test
    void  isAfterTest() {
        assertThat(Timestamp.valueOf(instantAfter)
                .isAfter(Timestamp.valueOf(instant)))
                .isTrue();
    }

}
