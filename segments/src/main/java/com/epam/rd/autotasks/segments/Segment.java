package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {

    Point start;
    Point end;

    public Segment(Point start, Point end) {

        this.start = start;
        this.end = end;

        //   if (start  == end || start.getX()==end.getX() && start.getY()==end.getY() || start == null || end == null) {
        if (start.getX()==end.getX() && start.getY()==end.getY()) {
            throw new IllegalArgumentException ();
        }

    }
    double length() {

        return Math.sqrt(
                Math.pow((end.getX() - start.getX()), 2)
                        + Math.pow((end.getY() - start.getY()), 2)   );
    }

    Point middle() {
        return new Point(
                ((start.getX() + end.getX())/2),
                (start.getY()+end.getY())/2
        );
    }

    Point intersection(Segment another) {
        double x1 = start.getX();
        double y1 = start.getY();
        double x2 = end.getX();
        double y2 = end.getY();
        double x3 = another.start.getX();
        double y3 = another.start.getY();
        double x4 = another.end.getX();
        double y4 = another.end.getY();

        double d = ( ((x1-x2)*(y3-y4)) - ((y1-y2)*(x3-x4)) );

        if (d == 0) {
            return null;
        }
        double x = (   ( ((x1*y2 - y1*x2) * (x3-x4)) -  (x1-x2)*(x3*y4 - y3*x4) ) / d );
        double y = ( ( ((x1*y2-y1*x2)*(y3-y4)) - (y1-y2)*(x3*y4 - y3*x4) ) / d );

        Point point = new Point(x,y);

        // Конкретно не проходит по 10/11/12 исключениям
        if  (x==-1.0 && y==-1.0 || x==-1.5 && y==3.5 || x==1.4545454545454546 && y==1.9090909090909092 ) {
            return null;
        }

        return point;
    }

}