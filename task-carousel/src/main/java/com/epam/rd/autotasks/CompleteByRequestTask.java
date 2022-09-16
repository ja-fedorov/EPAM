package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
boolean end = false;
boolean lastCheck = false;

    public CompleteByRequestTask() {
    }

    @Override
    public void execute() {
        if (lastCheck) {
            end = true;
        }
    }

    @Override
    public boolean isFinished() {
            return end;
    }

    public void complete() {
        lastCheck = true;
    }
}
