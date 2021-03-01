package com.sachin.pratice.program.codility;

public class Test {
	public static void main(String[] args) {
		int arr[] = { 3, 4, 5, 4 };
		// int arr[] = {4, 5, 2, 3, 4};

		new Test().solution(arr);
	}

	public int solution(int[] arr) {
		// write your code in Java SE 8
		int count = 0;
		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i] >= arr[i - 1] && (i + 1 < arr.length && arr[i + 1] >= arr[i - 1]))
				count++;
			else if (arr[i] < arr[i - 1])
				break;
		}
		return count;
	}

	private void run() {
		int combination = 1;
		int duplicateCount = 0;
		boolean foundAnamoly = false;
		int valueBeforeAnamoly = Integer.MAX_VALUE;
		int[] trees = { 3, 4, 5, 4 };
		int prevNumber = trees[0];
		for (int i = 1; i < trees.length; i++) {
			if (prevNumber < trees[i]) {
				combination++;
				duplicateCount = 0;
			} else if (prevNumber == trees[i]) {
				combination++;
				duplicateCount++;
			} else {
				if (!foundAnamoly) {
					foundAnamoly = true;
					valueBeforeAnamoly = trees[i];
					combination = 1;
				} else {
					// Duplicate anamoly
					combination = 0;
					break;
				}
				duplicateCount = 0;
			}
			prevNumber = trees[i];
		}
	}
}
