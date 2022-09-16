package com.epam.rd.autotasks.meetstrangers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {
        //Write a program, asks for a number - amount of strangers to meet.
        //Then reads stranger names line by line and prints line by line "Hello, ...".
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        if (number == 0) {
            System.out.println("Oh, it looks like there is no one here");
        } else if (number < 0) {
            System.out.println("Seriously? Why so negative?");
        } else {

            String[] names = new String[number];

            for (int i = 0; i < number; i++) {
                names[i] = reader.readLine();
                // names [i] = scanner.readLine();
            }
            for (int i = 0; i <number; i++) {
                System.out.println("Hello, " + names[i]);
            }
        }
    }
}