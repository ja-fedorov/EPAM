package com.shpp.p2p.cs.yfedorov.assignment2;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;


public class Assignment2Part5 extends WindowProgram {

    /* The number of rows and columns in the grid, respectively. */
    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 6;

    /* The width and height of each box. */
    private static final double BOX_SIZE = 40;

    /* The horizontal and vertical spacing between the boxes. */
    private static final double BOX_SPACING = 10;


    public void run() {

        /*
         * All methods are described here:
         * so 1-st method make large black rectangle with
         * preferences describe upper (number rows and columns etc.)
         *
         * Next step we draw vertical and horizontal rectangles
         *
         * All methods make a mark to the central screen positions */

        drawBigBlackRectagle();
        drawVerticalLines();
        drawHorizontalLines();


    }

    private void drawHorizontalLines() {
        for (int i = 1; i < NUM_COLS; i++) {
            GRect line = new GRect((getWidth() / 2) - (NUM_ROWS / 2 * BOX_SIZE) - ((NUM_ROWS - 1) / 2 * BOX_SPACING),
                    (getHeight() / 2) - (NUM_COLS / 2 * BOX_SIZE) - ((NUM_COLS - 1) / 2 * BOX_SPACING) + BOX_SIZE * i + BOX_SPACING * (i - 1),
                    BOX_SIZE * NUM_ROWS + (NUM_ROWS - 1) * BOX_SPACING,
                    BOX_SPACING);
            line.setFilled(true);
            line.setColor(Color.WHITE);
            line.setFillColor(Color.WHITE);
            add(line);
        }
    }

    private void drawVerticalLines() {
        for (int i = 1; i < NUM_ROWS; i++) {
            GRect line = new GRect((getWidth() / 2) - (NUM_ROWS / 2 * BOX_SIZE) - ((NUM_ROWS - 1) / 2 * BOX_SPACING) + BOX_SIZE * i + BOX_SPACING * (i - 1),
                    (getHeight() / 2) - (NUM_COLS / 2 * BOX_SIZE) - ((NUM_COLS - 1) / 2 * BOX_SPACING),
                    BOX_SPACING,
                    BOX_SIZE * NUM_COLS + (NUM_COLS - 1) * BOX_SPACING);
            line.setFilled(true);
            line.setColor(Color.WHITE);
            line.setFillColor(Color.WHITE);
            add(line);
        }
    }

    private void drawBigBlackRectagle() {
        GRect blackRectagle = new GRect(
                (getWidth() / 2) - (NUM_ROWS / 2 * BOX_SIZE) - ((NUM_ROWS - 1) / 2 * BOX_SPACING),
                (getHeight() / 2) - (NUM_COLS / 2 * BOX_SIZE) - ((NUM_COLS - 1) / 2 * BOX_SPACING),
                NUM_ROWS * BOX_SIZE + (NUM_ROWS - 1) * BOX_SPACING,
                NUM_COLS * BOX_SIZE + (NUM_COLS - 1) * BOX_SPACING);
        blackRectagle.setFilled(true);
        blackRectagle.setColor(Color.BLACK);
        blackRectagle.setFillColor(Color.BLACK);
        add(blackRectagle);
    }
}


