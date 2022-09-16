package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0),
    NE(45),
    E(90),
    SE(135),
    S(180),
    SW(225),
    W(270),
    NW(315);

   private int degrees;

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    public int getDegrees() {
        return degrees;
    }

    public void setDegrees(int degrees) {
        this.degrees = degrees;
    }

    public static int checkDegrees (int degrees) {
       if (degrees >= 360) {
           degrees %= 360;
       }
       if (degrees < 0) {
           degrees +=360;
       }
       return degrees;
   }

    public static Direction ofDegrees(int degrees) {
        degrees = checkDegrees(degrees);

        for (Direction direction : Direction.values()) {
            if (direction.degrees == degrees) {
                return direction;
            }
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        degrees = checkDegrees(degrees);
        Direction x = N;

        if (degrees <=23)
            x = N;
        if (degrees >23 && degrees <=NE.degrees + 23)
            x = NE;
        if (degrees >NE.degrees + 23 && degrees <=E.degrees + 23)
            x = E;
        if (degrees >E.degrees + 23 && degrees <=SE.degrees + 23)
            x = SE;
        if (degrees >SE.degrees + 23 && degrees <=S.degrees + 23)
            x = S;
        if (degrees >S.degrees + 23 && degrees <=SW.degrees + 23)
            x = SW;
        if (degrees >SW.degrees + 23 && degrees <=W.degrees + 23)
            x = W;
        if (degrees >W.degrees + 23 && degrees <=NW.degrees + 23)
            x = NW;
        return x;
    }

    public Direction opposite() {

       int result = checkDegrees (degrees - 180);
       return ofDegrees (result);

    }

    public int differenceDegreesTo(Direction direction) {
        int difference = Math.abs(degrees - direction.degrees);

        if (difference == 315) {
            difference = 45;
        }

        return difference;
    }
}
