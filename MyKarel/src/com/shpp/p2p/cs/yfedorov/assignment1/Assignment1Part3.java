package com.shpp.p2p.cs.yfedorov.assignment1;

import com.shpp.karel.KarelTheRobot;

// choose map: MidpointFinding
// test map: CheckerBoard

public class Assignment1Part3 extends KarelTheRobot {

    public void run() throws Exception {

        move();
        putFirstBeepersLine();
        turnAround();

        // We should to check is available 2 Beepers - so we put Karel on the second Cell and after that
        // check if Karel stay on a Beeper
        move();
        move();

        // We will pick Beepers from each side, and when remain only 1 Beeper - Karel is stop, and we get a center of a Raw;
        while (beepersPresent()) {
            pickBeeperFromTheSides();
            changeTheSides();
        }
    }

    private void changeTheSides() throws Exception {
        move();
        while (beepersPresent()){
                move();
            }
        turnAround();
        move();
        move();
    }

    private void pickBeeperFromTheSides() throws Exception {

        if (beepersPresent()) {
                turnAround();
                move();
                pickBeeper();
                turnAround();
            }
        move();
        }


    private void turnAround() throws Exception {
            turnLeft();
            turnLeft();
    }

    private void putFirstBeepersLine() throws Exception {
        while (frontIsClear())
            if (noBeepersPresent()) {
                putBeeper();
                move();
            }
    }
}