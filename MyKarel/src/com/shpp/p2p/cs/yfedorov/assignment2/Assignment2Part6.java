package com.shpp.p2p.cs.yfedorov.assignment2;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part6 extends WindowProgram {

    /* Important!
     * Caterpillar can only contain pair numbers of Circle!!!
     * And QANTITY_OF_CATERPILLAR_CELL will increase total amount of circles in 2!
     * */
    public static final int QANTITY_OF_CATERPILLAR_CELL = 4;

    /* Absolutely static number - better do not touch )
     * Radius of caterpillar circle;
     *
     * to make a test can choose 200 */
    public static final int RADIUS = 100;

    public void run() {

        /*  Make a 2 circle in one loop
         * Properties described below  */
        for (int i = 0; i < QANTITY_OF_CATERPILLAR_CELL; i++) {
            GOval oval = new GOval(50 + i * 100, 100, RADIUS, RADIUS);
            oval.setFilled(true);
            oval.setColor(Color.RED);
            oval.setFillColor(Color.GREEN);
            add(oval);

            GOval oval2 = new GOval(100 + i * 100, 50, RADIUS, RADIUS);
            oval2.setFilled(true);
            oval2.setColor(Color.RED);
            oval2.setFillColor(Color.GREEN);
            add(oval2);
        }

    }

}
