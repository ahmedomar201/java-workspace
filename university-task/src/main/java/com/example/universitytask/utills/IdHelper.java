package com.example.universitytask.utills;

import java.util.UUID;

public final class IdHelper {

    private IdHelper() {
        throw new AssertionError("Utility class");
    }

    public static UUID randomId() {
        return UUID.randomUUID();
    }
}
