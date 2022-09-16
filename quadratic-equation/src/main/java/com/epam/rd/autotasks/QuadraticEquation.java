package com.epam.rd.autotasks;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        //ax^2 + bx + c =0;
        double d = b*b - 4*a*c;

        if (d==0) {
            double x = (-1*b)/(2*a);
            System.out.println(x);
        }
        else if (d>0) {
            double x1 = (-1*b - Math.sqrt(d)) / (2*a);
            double x2 = (-1*b + Math.sqrt(d)) / (2*a);
            System.out.println(x1 + " " + x2);
        }
        else {
            System.out.println("no roots");
        }

    }

}