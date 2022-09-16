package com.shpp.p2p.cs.yfedorov.assignment1;

// choose map: StoneMason

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part2 extends KarelTheRobot {
    @Override
    public void run() throws Exception {

        // Put Beepers in 1-st raw
        makeWallFromBeepers();

        // Put Beepers in all next columns
        while (rightIsClear()) {
            checkForAnotherColumnAndGoThere();
            makeWallFromBeepers();
        }
    }

    private void checkForAnotherColumnAndGoThere() throws Exception {
        if (rightIsClear()) {
            turnLeft();
            turnLeft();
            while (frontIsClear()){
                move();
            }
            turnLeft();
            for (int i = 0; i < 4; i++) {
                move();
            }
        }
    }


    private void makeWallFromBeepers() throws Exception {

        turnLeft();

        while (frontIsClear()) {
        if (noBeepersPresent()) {
            putBeeper();
        }
            move();
            if (noBeepersPresent()) {
                putBeeper();
            }
        }

    }
}