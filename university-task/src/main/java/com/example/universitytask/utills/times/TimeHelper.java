package com.example.universitytask.utills.times;

import java.sql.Timestamp;
import java.time.Instant;

public final class TimeHelper {

    private TimeHelper() {
        throw new AssertionError("utility Class");
    }

    public static Timestamp currentTimestamp() {
        return Timestamp.from(Instant.now());
    }
}
