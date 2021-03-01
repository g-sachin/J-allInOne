package com.sachin.pratice.programs.hackerrank;

import java.util.Arrays;

public class TwoDArray {

	public static void main(String[] args) {
		new TwoDArray().checkArr();
	}

	/**
	 * int arr[][] = {
				{ 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 0, 0, 0, 0 },
				{ 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 2, 4, 4, 0 },
				{ 0, 0, 0, 2, 0, 0 },
				{ 0, 0, 1, 2, 4, 0 } };
	 */
	private void checkArr() {
		/*int arr[][] = {
				{ 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 0, 0, 0, 0 },
				{ 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 2, 4, 4, 0 },
				{ 0, 0, 0, 2, 0, 0 },
				{ 0, 0, 1, 2, 4, 0 } };
*/
		int arr[][] = {
			{0, -4, -6, 0, -7, -6},
			{-1, -2, -6, -8, -3, -1},
			{-8, -4, -2, -8, -8, -6},
			{-3, -1, -2, -5, -7, -4},
			{-3, -5, -3, -6, -6, -6},
			{-3, -6, 0, -8, -6, -7}
		};
		int n=6;
		int high = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for(int j=0; j<arr.length;j++){
				if ((i < n - 2) && (j < n - 2)) {
					int start[][] = new int[3][3];
					start[0][0] = arr[i][j];
					start[0][1] = arr[i][j + 1];
					start[0][2] = arr[i][j + 2];
					start[1][1] = arr[i + 1][j + 1];
					start[2][0] = arr[i + 2][j];
					start[2][1] = arr[i + 2][j + 1];
					start[2][2] = arr[i + 2][j + 2];
					System.out.println("Array: " + Arrays.deepToString(start));

					int check = start[0][0] + start[0][1] + start[0][2] + start[1][1] + start[2][0] + start[2][1] + start[2][2];
					System.out.println("sum: "+check);
					/*
					System.out.println("check for every A*: "+check);
					int sum = 0;
					for (int res1 = 0; res1 < start.length; res1++) {
						for (int res2 = 0; res2 < start.length; res2++) {
							sum += start[res1][res2];
						}
					}
					if(sum > high){
						high = sum;
					}
					System.out.println("Sum: " + sum);*/
					if(check > high){
						high = check;
					}
				}	
			}
		}
		System.out.println("highest A*: "+high);
	}
}
