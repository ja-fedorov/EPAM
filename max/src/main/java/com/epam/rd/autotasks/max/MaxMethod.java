package com.epam.rd.autotasks.max;

public class MaxMethod {
    public static int max(int[] values) {

        int result = Integer.MIN_VALUE;
        for (int i = 0; i <values.length; i++) {
          if (values[i]>=result) {
              result = values[i];
          }
        }
        return result;
      //  throw new UnsupportedOperationException();
    }
}
