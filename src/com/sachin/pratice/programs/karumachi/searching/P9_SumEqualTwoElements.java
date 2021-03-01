package com.sachin.pratice.programs.karumachi.searching;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P9_SumEqualTwoElements {

	public static void main(String[] args) {
		int arr[] = {1, 4, 5, 6, 7, 2, 3, 11, 8, 6, -1, 19, 13};
		new P9_SumEqualTwoElements().bruteForce(arr, 12); //O(n2)
		System.out.println("*****************************************");
		new P9_SumEqualTwoElements().sortingSolution(arr, 12); //O(nlogn)
		System.out.println("*****************************************");
		new P9_SumEqualTwoElements().hashSolution(arr, 12);//O(n)
	}

	private void bruteForce(int arr[], int sum) {
		//O(n2)
		for(int i=0; i<arr.length;i++) {
			for(int j=i+1; j<arr.length; j++){
				if(sum == arr[i]+arr[j])
					System.out.printf("Pairs: %d, %d %n",arr[i], arr[j]);
			}
		}
	}

	private void sortingSolution(int[] arr, int sum) {
		Arrays.sort(arr);
		int i,j, temp;
		for(i=0, j = arr.length-1; i<j ;){
			temp = arr[i]+arr[j];
			if(temp == sum)
				System.out.println("PAIRS.."+arr[i]+"_"+arr[j]);
			if(temp < sum){
				i = i+1;
			} else {
				j = j-1;
			}
		}
	}

	private void hashSolution(int[] arr, int sum) {
		Set<Integer> set = new HashSet<>();
		//O(n)
		for(int i : arr){
			int target = sum - i;
			if(!set.contains(target)){
				set.add(i);
			} else {
				System.out.println("Unique pairs are "+i+"-"+target);
			}
		}
	}

}
