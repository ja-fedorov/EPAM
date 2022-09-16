package com.shpp.p2p.cs.yfedorov.assignment2;

import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.graphics.GRectangle;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

import static java.awt.Color.YELLOW;


public class Assignment2Part4 extends WindowProgram {

    /* Use the below parametrs to make each one Rectagle Diametr */
    public static final int END_RECTANGLE_X_POSITION = 100;
    public static final int END_RECTANGLE_Y_POSITION = 300;

    /* too quick change colors of flag make constans with colors
     * color 1 = left
     * color 2 = midl
     * color 3 - right*/
    public static final Color color1 = Color.BLACK;
    public static final Color color2 = Color.YELLOW;
    public static final Color color3 = Color.RED;

    public void run() {
        /* Look preferences below, with descriptions of methods */
        putTheRectagle(color1, 0, 0);
        putTheRectagle(color2, 100, 0);
        putTheRectagle(color3, 200, 0);

        putTheNameOfFlage();
    }

    /* Make an a posittion of Lables with text - name of country flag (Belgium)  */
    private void putTheNameOfFlage() {
        GLabel lable = new GLabel("Flag Of Belgium",
                getWidth() / 2 + END_RECTANGLE_X_POSITION,
                getHeight() / 2 + END_RECTANGLE_Y_POSITION * 2 / 3);
        lable.setColor(color1);
        lable.setFont("Verdana-" + END_RECTANGLE_X_POSITION / 5);
        add(lable);
    }

    /* Methods draw one rectangle with   */
    private void putTheRectagle(Color color, int x, int y) {

        // Using a start position coordinate "x" and "y" to draw a rectangle
        int startRectangleXposittion = (getWidth() / 2) - (END_RECTANGLE_X_POSITION) * 3 / 2;
        int startRectangleYposittion = (getHeight() / 2) - (END_RECTANGLE_Y_POSITION) / 2;

        /* Preferences to draw rectangle
         * each rectangle would be one of three color rectangle to make a Tricolor Flag  */
        GRect rectangle = new GRect(startRectangleXposittion + x,
                startRectangleYposittion + y,
                END_RECTANGLE_X_POSITION,
                END_RECTANGLE_Y_POSITION);
        rectangle.setFilled(true);
        rectangle.setColor(color);
        rectangle.setFillColor(color);
        add(rectangle);
    }
}

