package com.epam.rd.autotasks;

public class CarouselRun {

    private final String className;
    private final int[] carousel;
    private final int capacity;
    private int counter = 0;
    private boolean runIsFinished = false;

    public CarouselRun(int capacity, int[] carousel, String className){
        this.capacity = capacity;
        this.carousel = carousel;
        arrayIsEmptyCheck();
        this.className = className;
    }
    public int next() {
        if(isFinished())
        {
            return -1;
        }
        else
        {
            int returnNum = 0;
            while(returnNum == 0){
                if(carousel[counter] > 0){
                    returnNum = carousel[counter];
                    if(className.equals(DecrementingCarousel.class.getName()))
                    {
                        --carousel[counter];
                    }
                    else
                    {
                        carousel[counter] /= 2;
                    }
                    counterPP();
                }
                else
                {
                    counterPP();
                }
            }
            arrayIsEmptyCheck();
            return returnNum;
        }
    }
    public boolean isFinished() {
        return runIsFinished;
    }

    private void arrayIsEmptyCheck()
    {
        for(int num: carousel)
        {
            if(num != 0)
            {
                runIsFinished = false;
                break;
            }
            else
            {
                runIsFinished = true;
            }
        }
    }
    private void counterPP()
    {
        if(counter+1 >= capacity)
        {
            counter = 0;
        }
        else
        {
            counter++;
        }
    }
}
