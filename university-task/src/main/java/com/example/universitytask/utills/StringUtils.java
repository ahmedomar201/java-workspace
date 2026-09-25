package com.example.universitytask.utills;

public final class StringUtils {

    public StringUtils() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean isNullOrBlank(final String string) {
        return string == null || string.isBlank();
    }
}
