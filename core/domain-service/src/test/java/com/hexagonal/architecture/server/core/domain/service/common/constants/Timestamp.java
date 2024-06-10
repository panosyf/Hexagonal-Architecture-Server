package com.hexagonal.architecture.server.core.domain.service.common.constants;

import java.time.Instant;

public class Timestamp {

    private Timestamp() {
    }

    public static final Instant TIMESTAMP_1 = Instant.parse("2024-09-08T16:30:000Z");
    public static final Instant TIMESTAMP_2 = Instant.parse("2024-09-08T17:30:000Z");

}
