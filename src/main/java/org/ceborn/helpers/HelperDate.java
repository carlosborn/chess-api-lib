package org.ceborn.helpers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class HelperDate {

    public static int getYear(Date date) {
        try {
            LocalDate localDate = LocalDate.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
            return localDate.getYear();
        } catch (Exception e) {
            return LocalDate.EPOCH.getYear();
        }
    }

    public static int getMonth(Date date) {
        try {
            LocalDate localDate = LocalDate.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
            return localDate.getMonthValue();
        } catch (Exception e) {
            return LocalDate.EPOCH.getMonthValue();
        }
    }

    public static int getYear() {
        return getYear(new Date());
    }

    public static int getMonth() {
        return getMonth(new Date());
    }

}
