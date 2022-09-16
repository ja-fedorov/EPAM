package com.epam.rd.autotasks.sequence;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {

        // Put your code here
        Scanner scanner = new Scanner (System.in);
        int num;
        int max =0;
        int min = 0;
        do {
            num = scanner.nextInt();
            if (num == 0) {
                continue;
            }
            if (max<num) {
                max=num;
            }
            if (num<0 && max==0) {
                max=num;
            }
        }
        while (num !=0);

        return max;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        System.out.println(max());
    }
}
