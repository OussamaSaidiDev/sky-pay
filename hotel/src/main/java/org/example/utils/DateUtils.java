package org.example.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {
    public static int calculateDays(Date date1, Date date2){
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("Dates cannot be null");
        }

        long diffInMillis = Math.abs(date2.getTime() - date1.getTime());
        return (int) TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
    }
}
