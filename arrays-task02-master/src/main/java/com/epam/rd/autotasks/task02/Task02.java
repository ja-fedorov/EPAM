package com.epam.rd.autotasks.task02;

public class Task02 {

	public static int maximumDistance(int[] array) {
		// TODO: Implement this method.


		int n = array.length;
		int result = 0;


		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (array[i] == array[j]
				&& array[i] = Math.max(array)
				) {
					result = Math.max(result, j - i);

				}
			}
		}
		if (array.length == 0) {result = 0;}

		return result;
	}


	public static void main(String[] args) {
		{
			int[] array = null;
			System.out.println("result = " + maximumDistance(array));
		}
		{
			int[] array = new int[] {};
			System.out.println("result = " + maximumDistance(array));
		}
		{
			int[] array = new int[] { 4, 100, 3, 4 };
			System.out.println("result = " + maximumDistance(array));
		}
		{
			int[] array = new int[] { 5, 50, 50, 4, 5 };
			System.out.println("result = " + maximumDistance(array));
		}
		{
			int[] array = new int[] { 5, 350, 350, 4, 350 };
			System.out.println("result = " + maximumDistance(array));
		}
		{
			int[] array = new int[] { 10, 10, 10, 10, 10 };
			System.out.println("result = " + maximumDistance(array));
		}
	}

}
