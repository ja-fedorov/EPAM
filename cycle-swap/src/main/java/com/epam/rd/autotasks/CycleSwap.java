package com.epam.rd.autotasks;

class CycleSwap {
    static void cycleSwap(int[] array) {
        if (array != null && array.length > 0) {

            int number = array[array.length-1];
            for (int i = array.length-1; i > 0; i--) {
                array[i] = array[i-1];
            }
            array[0] = number;
        }
    }
    static void cycleSwap(int[] array, int shift) {
            if (array !=null && array.length>0 && shift<=array.length) {


                int [] bigArray = new int [array.length*2];
                System.arraycopy(array, 0,bigArray, 0, array.length);
                int dif = array.length - shift;
                for (int i=0; i<dif; i++) {
                    bigArray[array.length+i] = array[i];
                }

                System.arraycopy(bigArray, dif , array, 0,array.length);
                }

            }
}
