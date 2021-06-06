package com.sachin.pratice.programs.gfg.recursion;

/**
 * Find count of subset of array whose sum is equal to given num
 * 
 * I/P: [10, 5, 2, 3, 6]
 * number: 8
 * 
 * O/P: 2 [{3,5}, {2, 6}]
 * 
 * I/P: [10, 20, 15]
 * number: 0
 * 
 * O/P: 1 [{}] - empty set also subset.
 * 
 * 
 * I/P: [10, 20, 15]
 * number: 37
 *
 * O/P: 0 - none subset has sum equal to 37
 * @author GUR40832
 *
 */
public class SubsetSum {
	public static void main(String[] args) {
		int arr[] = {10, 5, 3, 2, 6};
		//int arr[] = {10, 20, 15};
		int target = 8;
		int arrLength = arr.length;
		
		System.out.println("Total subset are: " +sumSubet(arr, target, arrLength));
		
		//Iterative solution
		//PairsInArray
	}

	private static int sumSubet(int arr[], int sum, int n) {
		if(n == 0) { //base condition; stop when n becomes zero mean last point in recursion tree
			return 	sum == 0?1:0;
		}
		return sumSubet(arr, sum, n-1)+ sumSubet(arr, sum - arr[n-1], n-1);
	}
}
