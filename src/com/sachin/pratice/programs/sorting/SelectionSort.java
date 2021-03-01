package com.sachin.pratice.programs.sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		new SelectionSort().sort();
		new SelectionSort().sortWithNegativeNum();
	}

	private void sort() {
		int input[] = { 4, 2, -1, 15, 5, 19, 0, -3 };
		int index;
		for (int i = 0; i < input.length; i++) {
			index = i;
			for (int j = i + 1; j < input.length; j++) {
				if (input[j] < input[index]) //find lowest element
					index = j;
			}
			int lowest = input[index];
			input[index] = input[i];
			input[i] = lowest;
		}
		System.out.println("Sorted Array: " + Arrays.toString(input));
	}

	/**
	 * You are given a sorted array containing both negative and positive
	 * values. Resort the array taking absolute value of negative numbers. Your
	 * complexity should be O(n)
	 * 
	 * Example
	 * A = {-8,-5,-3,-1,3,6,9}
	 * Output: {-1,-3,3,-5,6,-8,9}
	 */
	private void sortWithNegativeNum() {
		int input[] = { -8,-5,-3,-1,3,6,9};
		int index;
		for (int i = 0; i < input.length; i++) {
			index = i;
			for (int j = i + 1; j < input.length; j++) {
				if(input[j] < 0)
					input[j] = Math.abs(input[j]);
				if (input[j] < input[index])
					index = j;
			}
			int lowest = input[index];
			input[index] = input[i];
			input[i] = lowest;
		}
		System.out.println("With negtive: " + Arrays.toString(input));
	}

}
