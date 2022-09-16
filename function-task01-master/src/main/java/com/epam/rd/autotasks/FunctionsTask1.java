package com.epam.rd.autotasks;


class FunctionsTask1 {
    /**
     * <summary>
     * Implement code according to description of task.
     * </summary>
     * if set invalid arguments in method, then method must throws
     * IllegalArgumentException
     */
    public int[] methodSumIndexAndElementIArray (int[] array) {

        int [] arrayWithSumIndex = new int[array.length];

        for (int i = 0; i < array.length ; i++) {
            arrayWithSumIndex[i] = array[i] + i;
        }

        return arrayWithSumIndex;

        }
}



