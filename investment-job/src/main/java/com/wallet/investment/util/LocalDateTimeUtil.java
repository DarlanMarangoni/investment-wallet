package com.wallet.investment.util;

import java.time.LocalDateTime;

public class LocalDateTimeUtil {

    public static final int ZERO = 0;

    public static LocalDateTime roundSeconds(LocalDateTime localDateTime) {
        return roundNano(localDateTime.withSecond(ZERO));
    }

    private static LocalDateTime roundNano(LocalDateTime localDateTime) {
        return localDateTime.withNano(ZERO);
    }
}
