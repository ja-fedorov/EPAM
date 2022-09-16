package com.epam.rd.autotasks.meetautocode;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import static java.lang.String.format;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();

        int day = 60*60*24;
        seconds = seconds % day;
        int minutes = seconds / 60 % 60;
        int hours = seconds / 60 / 60 % 24;
        seconds = seconds % 60;

        String date = String.format("%d:%02d:%02d", hours, minutes, seconds);

        System.out.println(date);
    }
}
