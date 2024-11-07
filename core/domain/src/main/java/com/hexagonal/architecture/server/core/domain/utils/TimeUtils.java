package com.hexagonal.architecture.server.core.domain.utils;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class TimeUtils {

    public static Instant now() {
        return Instant.now().truncatedTo(ChronoUnit.NANOS);
    }

    public static Instant time(final String time) {
        return Instant.parse(time).truncatedTo(ChronoUnit.NANOS);
    }

}
