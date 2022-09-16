package com.shpp.p2p.cs.yfedorov.assignment1;

import com.shpp.karel.KarelTheRobot;

// original map: CheckerBoard
// test map: MidpointFinding

public class Assignment1Part4 extends KarelTheRobot {

    public void run () throws Exception {

        makeRaw();
        while (frontIsClear()) {
            choosePosition();
            makeRaw();
        }
    }

    private void choosePosition() throws Exception {

        // When we have unpaired numbers in Raw
        if (noBeepersPresent()) {
            move();
            if (rightIsBlocked()) {
                turnLeft();
            }
            if (leftIsBlocked()) {
                turnRight();
            }

        }

        // When we have paired number in Raw
        else {
            if (rightIsBlocked()) {
                move();
                turnLeft();
                move();
            }
            if (leftIsBlocked()) {
                move();
                turnRight();
                move();
            }
        }
    }

    private void makeRaw() throws Exception {

        // We must put first Beeper in first Cell
        putBeeper();

        // After that we should to skip 2 cells and if the second cell is available will put a Beeper there.
        // (is available it's mean - we still on a ChessTable)
        while (frontIsClear()) {
            move();
            if (frontIsClear()) {
                move();
                putBeeper();
            }
        }
        // On the end of this method our Karel should to watch on North.
        if (facingEast()) {
            turnLeft();
        }
        if (facingWest()) {
            turnRight();
        }
    }

    private void turnRight() throws Exception{
        for ( int  i = 0; i <3 ; i++)    {
            turnLeft();
        }
    }



}
