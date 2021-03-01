package com.sachin.pratice.program.codility;

import java.util.Arrays;

/**
 * An array A consisting of N integers is given. Rotation of the array means
 * that each element is shifted right by one index, and the last element of the
 * array is moved to the first place. For example, the rotation of array
 *  A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6
 * is moved to the first place).
 * 
 * @author Sachin
 *
 */
public class RightShift {
	public static void main(String[] args) {
		int rightShift[] = { 3, 8, 9, 7, 6 };
		rightShift(rightShift, 3);
	}

////////////////////////////////////////////////////////
//Right Shift Array
	public static int[] rightShift(int arr[], int shift) {
		for (int i = 0; i < shift; i++) {
			int temp = arr[arr.length - 1];
			for (int j = arr.length - 1; j > 0; j--) {
				arr[j] = arr[j - 1];
			}
			arr[0] = temp;
		}
		System.out.println("final array after right shift: " + Arrays.toString(arr));
		return arr;
	}
}
