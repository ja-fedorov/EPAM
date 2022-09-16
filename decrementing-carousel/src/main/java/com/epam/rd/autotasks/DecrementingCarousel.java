package com.epam.rd.autotasks;

public class DecrementingCarousel {
    static int capacity;
    static int [] array;
    int counter =0;
    boolean isRun = false;

    public DecrementingCarousel(int capacity) {
        DecrementingCarousel.capacity = capacity;
        array = new int[capacity];
    }


    public boolean addElement(int element){
        if (counter < capacity && element >0 && !isRun) {
            array[counter] = element;
            counter++;
            return true;
        }
            return false;
    }

    public CarouselRun run(){
       if (!isRun) {
           isRun = true;
           return new CarouselRun();
       }
       return null;
    }
}
