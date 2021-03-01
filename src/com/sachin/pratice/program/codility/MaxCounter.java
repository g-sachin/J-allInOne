package com.sachin.pratice.program.codility;

/**
 * 
 * Calculate the values of counters after applying all alternating operations:
 * increase counter by 1; set value of all counters to current maximum.
 * 
 * @description
 * 
 *              You are given N counters, initially set to 0, and you have two
 *              possible operations on them:
 * 
 *              increase(X):  counter X is increased by 1, 
 *              max counter:  all counters are set to the maximum value of any counter.
 *              A non-empty array A of M integers is given. This array represents
 *              consecutive operations:
 * 
 *              if A[K] = X, such that 1 ≤ X ≤ N, then operation K is
 *              increase(X), if A[K] = N + 1 then operation K is max counter.
 *              For example, given integer N = 5 and array A such that:
 * 
 *              A[0] = 3 A[1] = 4 A[2] = 4 A[3] = 6 A[4] = 1 A[5] = 4 A[6] = 4
 *              the values of the counters after each consecutive operation will
 *              be:
 * 
 *              (0, 0, 1, 0, 0) (0, 0, 1, 1, 0) (0, 0, 1, 2, 0) (2, 2, 2, 2, 2)
 *              (3, 2, 2, 2, 2) (3, 2, 2, 3, 2) (3, 2, 2, 4, 2) The goal is to
 *              calculate the value of every counter after all operations.
 *              
 * @return the function should return [3, 2, 2, 4, 2], as explained above.
 * 
 * @author Sachin
 *
 */
public class MaxCounter {

	public static void main(String[] args) {
		int A[] = {};
		System.out.println(""+1+2+""+1);
		new MaxCounter().solution(5, A);
	}

	public int[] solution(int n, int[] A) {
		// write your code in Java SE 8
		int arr[] = new int[n];
		int high = 0;
		for (int i : A) {
			if (i <= n) {
				arr[i - 1]++;
			} else {
				for (int j = 0; j < arr.length; j++)
					arr[j] = high;
			}
			// System.out.println("arr: "+Arrays.toString(arr));
			// System.out.println("elem: "+(arr[i-1]));
			if (i <= n && arr[i - 1] > high)
				high = arr[i - 1];
			// System.out.println("highest: "+high);
		}
		return arr;
	}
}
