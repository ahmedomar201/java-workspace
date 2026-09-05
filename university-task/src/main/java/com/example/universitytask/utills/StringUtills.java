package com.example.universitytask.utills;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtills {



    public   static boolean isNullOrBlank(final String string) {
        return string == null || string.isBlank();
    }
}
