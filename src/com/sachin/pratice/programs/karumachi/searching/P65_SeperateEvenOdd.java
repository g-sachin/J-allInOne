package com.sachin.pratice.programs.karumachi.searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Seperate 1's and 0's in an array
 * 
 * @author GUR40832
 *
 */
//DUTCH NATIONAL FLAG PROBLEM
public class P65_SeperateEvenOdd {
	public static void main(String[] args) {
		new P65_SeperateEvenOdd().bruteForce();
	}

	private void bruteForce() {
		//int arr[] = {12, 34, 45, 9, 8, 90, 3, 1};
		int arr[] = {0,1, 1,0 , 0, 1, 0,1, 0, 1, 1,0};
		int left = 0;
		int right = arr.length-1;
		
		while(left < right){
			
			while(arr[left] % 2 == 0 && left < right)
				left++;
			while(arr[right] % 2 == 1 && left < right)
				right--;
			
			if(left < right){
				//swap left <-> right
				int temp = arr[right];
				arr[right] = arr[left];
				arr[left] = temp;
				
				left++;
				right--;
			}
		}
		System.out.println(" "+Arrays.toString(arr));
	}

}
