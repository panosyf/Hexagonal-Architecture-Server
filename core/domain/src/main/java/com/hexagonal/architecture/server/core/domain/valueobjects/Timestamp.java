package com.hexagonal.architecture.server.core.domain.valueobjects;

import com.hexagonal.architecture.server.core.domain.exceptions.utils.messages.ErrorMessageConstants;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Objects;

import static com.hexagonal.architecture.server.core.domain.model.constants.ZoneId.UTC;

public class Timestamp extends ValueObject {

    private final Instant time;

    private Timestamp() {
        this.time = Instant.now();
    }

    private Timestamp(Instant time) {
        if (time == null)
            throw new IllegalArgumentException(ErrorMessageConstants.TIMESTAMP_CANNOT_BE_NULL);
        this.time = time;
    }

    public static Timestamp now() {
        return new Timestamp();
    }

    public static Timestamp valueOf(Instant time) {
        return new Timestamp(time);
    }

    public Instant getTime() {
        return this.time;
    }

    public boolean isBefore(Timestamp timestamp) {
        return this.time.isBefore(timestamp.getTime());
    }

    public boolean isAfter(Timestamp timestamp) {
        return this.time.isAfter(timestamp.getTime());
    }

    public Timestamp minusDays(int days) {
        validateValue(days);
        Instant instant = this.time.atZone(ZoneId.of(UTC)).minusDays(days).toInstant();
        return new Timestamp(instant);
    }

    public Timestamp plusDays(int days) {
        validateValue(days);
        Instant instant = this.time.atZone(ZoneId.of(UTC)).plusDays(days).toInstant();
        return new Timestamp(instant);
    }

    public Timestamp minusMonths(int months) {
        validateValue(months);
        Instant instant = this.time.atZone(ZoneId.of(UTC)).minusMonths(months).toInstant();
        return new Timestamp(instant);
    }

    public Timestamp plusMonths(int months) {
        validateValue(months);
        Instant instant = this.time.atZone(ZoneId.of(UTC)).plusMonths(months).toInstant();
        return new Timestamp(instant);
    }

    private void validateValue(int value) {
        if (value < 1) {
            throw new IllegalArgumentException(ErrorMessageConstants.VALUE_MUST_BE_AT_LEAST_ONE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timestamp timestamp = (Timestamp) o;
        return Objects.equals(time, timestamp.time);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(time);
    }

    @Override
    public String toString() {
        return "Timestamp{" +
                "time=" + time +
                '}';
    }

}
