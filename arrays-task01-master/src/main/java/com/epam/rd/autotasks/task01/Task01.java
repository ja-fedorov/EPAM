package com.epam.rd.autotasks.task01;

import java.util.Arrays;

public class Task01 {


	public static void swapEven(int[] array) {
		// TODO: Implement this method.
		if (array == null){
			return;
		}
		if (array.length == 0) {
			return;
		}
		int n = array.length;
		for (int i = 0; i < n; i++){
			for (int j = i + 1; j < n; j++){
				if (array[i] >= 0
						&& array[j] >=0
					&& array[i] % 2==0
					&& array[j] % 2==0){
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
//					break;
				}
			}
		}


		}



		public static void main (String[]args){
			{
				int[] array = null;
				swapEven(array);
				System.out.println(Arrays.toString(array));
			}
			{
				int[] array = new int[]{};
				swapEven(array);
				System.out.println(Arrays.toString(array));
			}
			{
				int[] array = new int[]{10, 5, 3, 4};
				swapEven(array);
				System.out.println(Arrays.toString(array));
			}
			{
				int[] array = new int[]{100, 2, 3, 4, 5};
				swapEven(array);
				System.out.println(Arrays.toString(array));
			}
			{
				int[] array = new int[]{100, 2, 3, 45, 33, 8, 4, 54};
				swapEven(array);
				System.out.println(Arrays.toString(array));
			}
		}
	}




