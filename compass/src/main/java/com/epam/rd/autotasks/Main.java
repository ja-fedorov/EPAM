package com.epam.rd.autotasks;

import static com.epam.rd.autotasks.Direction.N;
import static com.epam.rd.autotasks.Direction.ofDegrees;

public class Main {
    public static void main(String[] args) {
       int x= -360;
        Direction direction = Direction.N;
        x%=360;

        if (x == direction.getDegrees()) {
            System.out.println("Yes");
        }
    }
}
