package com.epam.rd.autotasks.intersection;

public class Line {
private int k;
private int b;
    public Line(int k, int b) {
this.k = k;
this.b = b;
    }

    public Point intersection(Line other) {
        // y = k1 * x + b1;
        // y = k2 * x + b2;
        // k1*x +b1 = k2*x +b2
        // x = (b2-b1) / (k1 - k2)
        int x;
        int y;
        try {
            x = (other.b - b) / (k - other.k);
            y = k * x + b;
        } catch (Exception e) {
            return null;
        }


        return new Point (x, y);
    }

}
