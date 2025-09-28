package com.hexagonal.server.application.service.common.constants.transaction;

import com.hexagonal.server.shared.kernel.common.valueobjects.Timestamp;

import java.time.Instant;

public class Timestamps {

    private Timestamps() {
    }

    public static final Timestamp TIMESTAMP_1 = Timestamp.valueOf(Instant.parse("2024-09-08T16:30:000Z"));
    public static final Timestamp TIMESTAMP_2 = Timestamp.valueOf(Instant.parse("2024-09-08T17:30:000Z"));

}
