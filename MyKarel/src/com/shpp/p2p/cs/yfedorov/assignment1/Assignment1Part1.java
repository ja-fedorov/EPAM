package com.shpp.p2p.cs.yfedorov.assignment1;

import com.shpp.karel.KarelTheRobot;

//  choose map: CollectNewsPaper

public class Assignment1Part1 extends KarelTheRobot {
    public void run () throws Exception {
    //go to Beeper
        turnRight();
        move ();
        turnLeft();

        move ();
        move ();
        move ();
        move ();

    //take a Beeper
        pickBeeper();

    // go home
        turnAround();
        move ();
        move ();
        move ();
        move ();
        turnRight();
        move ();

    // put a Beeper
        putBeeper();
    }

    void turnRight () throws Exception {
        for (int i = 0; i <3 ; i++) {
            turnLeft();
        }
    }
    void turnAround () throws Exception {
        turnLeft();
        turnLeft();
    }
}
