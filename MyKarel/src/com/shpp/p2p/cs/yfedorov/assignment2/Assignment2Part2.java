
package com.shpp.p2p.cs.yfedorov.assignment2;

import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part2 extends WindowProgram {

    public static final int APPLICATION_WIDTH = 300;
    public static final int APPLICATION_HEIGHT = 300;

    public static final int DIAMETR_CIRCLE = 100;
    public static final int FIRST_PLACE_CIRCLE_START =0;
    public static final int SECOND_PLACE_CIRCLE_START = APPLICATION_WIDTH - DIAMETR_CIRCLE; //200

    @Override
    public void run() {

        setLocation(APPLICATION_WIDTH, APPLICATION_HEIGHT);
       // setLocation(1000, 1000);
        // круг (овал) 1
        GOval circle = new GOval (FIRST_PLACE_CIRCLE_START,FIRST_PLACE_CIRCLE_START,DIAMETR_CIRCLE,DIAMETR_CIRCLE);
        circle.setFilled(true);
        circle.setFillColor(Color.BLACK);
        add(circle);


        // Circle 2
        GOval circle2 = new GOval (SECOND_PLACE_CIRCLE_START,FIRST_PLACE_CIRCLE_START,DIAMETR_CIRCLE,DIAMETR_CIRCLE);
        circle2.setFilled(true);
        circle2.setFillColor(Color.BLACK);
        add(circle2);


        // Circle 3
        GOval circle3 = new GOval (FIRST_PLACE_CIRCLE_START,SECOND_PLACE_CIRCLE_START,DIAMETR_CIRCLE,DIAMETR_CIRCLE);
        circle3.setFilled(true);
        circle3.setFillColor(Color.BLACK);
        add(circle3);


        // Circle 4
        GOval circle4 = new GOval (SECOND_PLACE_CIRCLE_START,SECOND_PLACE_CIRCLE_START,DIAMETR_CIRCLE,DIAMETR_CIRCLE);
        circle4.setFilled(true);
        circle4.setFillColor(Color.BLACK);
        add(circle4);



        // квадрат (прямоугольник)
       GRect rectagle = new GRect (DIAMETR_CIRCLE/2, DIAMETR_CIRCLE/2, SECOND_PLACE_CIRCLE_START, SECOND_PLACE_CIRCLE_START);
        rectagle.setFilled(true);
        rectagle.setColor(Color.WHITE);
        rectagle.setFillColor(Color.WHITE);
        add(rectagle);
    }
}

