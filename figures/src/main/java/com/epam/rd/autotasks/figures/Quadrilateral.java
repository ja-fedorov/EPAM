package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {

    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area() {
        // Formula Gauss
        return 0.5 * Math.abs(a.getX() * b.getY() + b.getX() * c.getY() + c.getX() * d.getY() + d.getX() * a.getY() -
                b.getX() * a.getY() - c.getX() * b.getY() - d.getX() * c.getY() - a.getX() * d.getY());
    }

    @Override
    public String pointsToString() {
        return a.toString() + b.toString() + c.toString() + d.toString();
    }

    @Override
    public Point leftmostPoint() {
        if (a.getX() <= b.getX() && a.getX()<=c.getX() && a.getX() <= d.getX()) {
            return a;
        }
        else if (b.getX()<=c.getX() && b.getX() <= d.getX()) {
            return b;
        }
        else if (c.getX() <= d.getX()) {
            return c;
        }
        else return d;
    }

    @Override
    public String toString() {
        return "Quadrilateral[" + pointsToString() +']';
    }
}
