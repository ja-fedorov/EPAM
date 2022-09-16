package com.epam.rd.autotasks.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{-3, 2, 4, 3, 5, 12, 8};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array){

        ArrayList<Integer> list = new ArrayList<Integer>();

        // Check first section of array
        if(array[0]<array[1]) {
            list.add(array[0]);
        }
        // Check all section of array without first and last
        for (int i = 1; i <array.length-1 ; i++) {
            if (array[i]<=array[i+1] && array[i]<= array[i-1]) {
                list.add(array[i]);
            }
        }
        // Check last section of array
        if(array[array.length-1]<array[array.length-2]) {
            list.add(array[array.length-1]);
        }


        int [] newArray = new int [list.size()+1];

        for (int i = 0; i < list.size() ; i++) {
            newArray[i] = list.get(i);
        }
        return newArray;
    }
}
