package com.epam.rd.autotasks.figures;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.Arrays;

import static java.lang.Math.abs;

class Triangle extends Figure{

    private final Point a;
    private final Point b;
    private final Point c;
    private final Segment ab;
    private final Segment bc;
    private final Segment ca;

    public Triangle(Point a, Point b, Point c) {

        ab = new Segment(a, b);
        bc = new Segment(b, c);
        ca = new Segment(c, a);

        double[] lengthArray = new double[]{
                abs(ab.length() * 100),
                abs(bc.length() * 100),
                abs(ca.length() * 100)};
        Arrays.sort(lengthArray);

        if (isRelativelyEqual(lengthArray[0] + lengthArray[1], lengthArray[2]))
            throw new IllegalArgumentException("Exception because such a triangle would be degenerative");

        this.a = a;
        this.b = b;
        this.c = c;

    }

    public double area() {

        double k1, k2, b1, b2, x, y;

        if (b.getX() == c.getX())
            return bc.length() * abs(a.getX() - b.getX()) / 2;

        if (b.getY() == c.getY())
            return bc.length() * abs(a.getY() - b.getY()) / 2;

        k1 = Segment.getA(bc.getStart(), bc.getEnd());
        b1 = Segment.getB(bc.getStart(), bc.getEnd());
        k2 = -1 / k1;
        b2 = a.getY() - k2 * a.getX();
        x = (b2 - b1) / (k1 - k2);
        y = k1 * x + b1;

        Segment h = new Segment(a, new Point(x, y));

        return h.length() * bc.length() / 2;

    }

    public String pointsToString() {
        return a.toString() + b.toString() + c.toString();
    }

    public Point leftmostPoint() {

        double[] points = new double[]{
                a.getX(),
                b.getX(),
                c.getX()
        };

        Arrays.sort(points);

        if (a.getX() == points[0]) return a;
        if (b.getX() == points[0]) return b;

        return c;
    }

    @Override
    public Point centroid(){

        Segment median1 = new Segment(a, bc.middle());
        Segment median2 = new Segment(b, ca.middle());

        return median1.intersection(median2);

    }

    @Override
    public boolean isTheSame(Figure figure) {
        return false;
    }
}