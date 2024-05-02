package com.cybilltek.technicalExam.util;

public class DateUtil {

    public static String truncateToDate(String dateString) {
        if (dateString.length() >= 10) {
            return dateString.substring(0, 10);
        } else {
            // If the string is shorter than 10 characters, return it as is
            return dateString;
        }
    }
}
