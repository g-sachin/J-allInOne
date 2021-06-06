package com.sachin.pratice.programs;

import java.util.HashSet;
import java.util.Set;

public class PairsInArray {

	public static void main(String[] args) {
		int arr[] = {13,-1, 6, 1, 12, 0, 19, 46, 9, 5, 20};
		PairsInArray obj = new PairsInArray();
		obj.find_bruteForce(arr, 19); //repeatable pair
		obj.find_bruteForce_UniquePair(arr, 19); //unique pair
		obj.find_HashSet(arr, 19);
	}

	/**
	 * 
Pair for sum: 19 is: 13,6
Pair for sum: 19 is: 6,13
Pair for sum: 19 is: 0,19
Pair for sum: 19 is: 19,0
Pair for sum: 19 is: -1,20
Pair for sum: 19 is: 20,-1
	 * @param input
	 * @param sum
	 */
	private void find_bruteForce(int input[], int sum) {
		for(int i=0; i<input.length;i++){
			int first=input[i];
			for(int j=0; j<input.length; j++){
				if(i==j) //same pair
					continue;
				int second = input[j];
				if(sum == first + second){
					System.out.println("Pair for sum: "+sum+" is: "+first+","+second );
					break;
				}
			}
		}
	}

	/**
	 * 
Unique Pair for sum: 19 is: 13,6
Unique Pair for sum: 19 is: 0,19
Unique Pair for sum: 19 is: -1,20
	 * @param arr
	 * @param sum
	 */
	private void find_bruteForce_UniquePair(int[] arr, int sum) {
		for(int i=0; i<arr.length;i++){
			int first = arr[i];
			for(int j=i+1; j<arr.length;j++){
				int second = arr[j];
				
				if(sum == first + second)
					System.out.println("Unique Pair for sum: "+sum+" is: "+first+","+second );
			}
		}
	}


	private void find_HashSet(int[] arr, int sum) {
		Set<Integer> set = new HashSet<>();
		for (int value : arr) {
			int target = sum - value;
			// if target number is not in set then add
			if (!set.contains(target)) {
				set.add(value);
			} else {
				System.out.printf("(%d, %d) %n", value, target);
			}
		}
	}

}
