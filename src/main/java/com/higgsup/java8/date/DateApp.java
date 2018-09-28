package com.higgsup.java8.date;

import java.time.*;
import java.time.temporal.ChronoField;

public class DateApp {

    public static void main(String[] args) {
        ZoneId vietnam = ZoneId.of("Asia/Ho_Chi_Minh");

        ZoneId hawaii = ZoneId.of("US/Hawaii");

        LocalDate nowVietNam = LocalDate.now(vietnam);

        System.out.println("Current time of Viet Nam: " + nowVietNam);
        LocalDateTime fullVietNam = LocalDateTime.now(vietnam);

        // get today time of Hawaii USA
        LocalDateTime fullHawaii = LocalDateTime.now(hawaii);

        System.out.println("Full current time of Viet Nam: " + fullVietNam);
        System.out.println("Full current time of Hawaii: " + fullHawaii);

        LocalDate localDate = LocalDate.now();
        System.out.printf("Ngay: %d - Thang: %d - Nam: %d %n", localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear());
        System.out.println("Note that: don't need to plus 1 when get month as java 7 ");

        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.printf("Ngay: %d - Thang: %d - Nam: %d \t Gio: %d - Phut: %d - Giay: %d %n", localDateTime.getDayOfMonth(), localDateTime.getMonthValue(), localDateTime.getYear()
                , localDateTime.getHour(), localDateTime.getMinute(), localDateTime.getSecond());


    }

}
