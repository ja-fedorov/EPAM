package com.epam.rd.autotasks.triangle;

class Triangle {

    static Point a;
    static Point b;
    static Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;

        // Проверка та то что все вершины трехугольника находятся не на одной прямой!!!

        if ((a.getX() - b.getX()) * (c.getY() - b.getY()) - (a.getY() - b.getY()) * (c.getX() - b.getX()) == 0) {
            throw new IllegalArgumentException();
        }
    }

    public double area() {
// S = 1/2 * |(x2-x1)(y3-y1)-(x3-x1)(y2-y1)|;
        double s;
            s = Math.abs(
                    (b.getX() - a.getX()) * (c.getY() - a.getY()) -
                            (c.getX() - a.getX()) * (b.getY() - a.getY())
            ) / 2.0;
            return s;
    }

    public Point centroid(){
        double x;
        double y;

        x = (a.getX() + b.getX() + c.getX()) / 3;
        y = (a.getY() + b.getY() + c.getY()) / 3;

        return new Point (x, y);
    }

}
