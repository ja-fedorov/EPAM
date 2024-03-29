package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        //Write a program, reading number of people and number of pieces per pizza and then
        //printing minimum number of pizzas to order to split all the pizzas equally and with no remainder
        Scanner scanner = new Scanner(System.in);
        int peopleQuantity = scanner.nextInt();
        int piecesInPizza = scanner.nextInt();
        int quantityPizza =1;


        while (quantityPizza * piecesInPizza % peopleQuantity != 0) {
            quantityPizza++;
        }
        System.out.println(quantityPizza);
    }
}
