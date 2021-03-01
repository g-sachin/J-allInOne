package com.sachin.pratice.programs.karumachi.searching;

import java.util.Arrays;

public class P67_MaxDifferenceTwoElements {

	public static void main(String[] args) {
		new P67_MaxDifferenceTwoElements().burteForce(); // O(n2)
		new P67_MaxDifferenceTwoElements().optimized(); //O(n)
	}

	private void burteForce() {
		int arr[] = { 2, 3, 10, 6, 8, 1, 4 };

		int maxDiff = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[i] && ((arr[j] - arr[i]) > maxDiff)) {
					maxDiff = arr[j] - arr[i];
				}
			}
		}
		System.out.println("Max Difference: " + maxDiff);
	}

	private void optimized() {
			
	}

}
