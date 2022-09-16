package com.epam.rd.autotasks;

public class CountDownTask implements Task{
private final int value;
int countDown;  // начальное значение обратного отсчета

    public CountDownTask(int value) {
        this.value = value;
        countDown = Math.max(value, 0); // countDown >= 0
    }

    public int getValue() {
       return countDown;
    }


    @Override
    public void execute() {
        if (!isFinished()) {
            countDown --;
        }
    }

    @Override
    public boolean isFinished() {
       return countDown == 0;

    }
}
