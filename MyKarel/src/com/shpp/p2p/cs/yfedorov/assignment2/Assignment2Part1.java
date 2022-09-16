package com.shpp.p2p.cs.yfedorov.assignment2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment2Part1 {

    public static void main(String[] args) throws IOException {

        /* Opening input stream and put him to Buffer */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Hi, this is a quadratic formula calculator!");

        /* Computer ask us to put the number. We should put 3 number one-by-one  */

        System.out.println("Put the 1-st Number (A): ");
        double a = Double.parseDouble(reader.readLine());
        System.out.println("Put the 2-st Number (B): ");
        double b = Double.parseDouble(reader.readLine());
        System.out.println("Put the 3-st Number (C): ");
        double c = Double.parseDouble(reader.readLine());

        /* Closing input stream */
        reader.close();

        /**
         *  Our Quadratic formula looks like combination x1 and x2.
         *  d it's a Discriminant
         */
        double d = b*b - 4*a*c;
        double x1 = (-b + Math.sqrt(d))/2*a;
        double x2 = (-b - Math.sqrt(d))/2*a;

        // To show the result use "text" and result of formula.

        if (d<0) {
            System.out.println("There are no real roots");
        }
        else {
            if (x1 == x2) {
                System.out.println("There is one root: " +x1);
            }
            else {
                System.out.println("There are two roots: " + x1 + " and " + x2);
            }
        }
    }
}
