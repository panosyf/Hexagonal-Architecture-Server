package com.hexagonal.architecture.server.core.domain.valueobjects;

import java.time.Instant;
import java.util.Objects;

public class Timestamp extends ValueObject {

    private final Instant time;

    private Timestamp() {
        this.time = Instant.now();
    }

    private Timestamp(Instant time) {
        this.time = Instant.now();
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
