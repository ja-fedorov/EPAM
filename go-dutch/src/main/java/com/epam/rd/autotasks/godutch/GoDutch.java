package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        //Write code here
        Scanner scanner = new Scanner (System.in);
        int billAmount = scanner.nextInt();
        int friendsQuantity = scanner.nextInt();

        if (billAmount < 0) {
            System.out.println("Bill total amount cannot be negative");
        }
        else if (friendsQuantity <= 0) {
            System.out.println("Number of friends cannot be negative or zero");
        }
        else {
            System.out.println(billAmount*110/100/friendsQuantity);
        }

    }
}
