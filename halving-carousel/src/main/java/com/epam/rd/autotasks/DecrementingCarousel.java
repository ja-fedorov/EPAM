package com.epam.rd.autotasks;

public class DecrementingCarousel {
    private int capacity;
    private int[] carousel;
    private boolean carouselIfFull = false;
    private int counter = 0;
    private boolean runIsGoing = false;

    public DecrementingCarousel(int capacity) {
        this.capacity=capacity;
        carousel = new int[capacity];
    }

    public boolean addElement(int element){

        if(carouselIfFull){
            return false;
        }
        else
        {
            if(element > 0){
                carousel[counter] = element;
                if(counter+1 >= capacity){
                    carouselIfFull = true;
                }
                counter++;
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public CarouselRun run(){
        if(runIsGoing){
            return null;
        }
        else {
            carouselIfFull = true;
            CarouselRun carouselRun = new CarouselRun(counter, carousel, getClassName());
            runIsGoing = true;
            return carouselRun;
        }
    }
    public String getClassName(){
        return getClass().getSimpleName();
    }
}
