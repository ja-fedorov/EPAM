package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Use Scanner methods to read input
       int number;
       int count = 0;
       int summ = 0;
        do {
            number = scanner.nextInt();
            if (number == 0) {
                continue;
            }
            count ++;
            summ +=number;

        }
        while (number != 0);
        System.out.println(summ/count);
    }

}