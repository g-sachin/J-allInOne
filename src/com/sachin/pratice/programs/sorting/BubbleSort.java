package com.sachin.pratice.programs.sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		new BubbleSort().sort();
	}

	private void sort() {
		//Psuedo code
		
		
		int arr[] = {5, 19, 9, 11, 2, 4};
		for(int i=0;i<arr.length-1;i++){
			for(int j=0; j<arr.length-1-i;j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println("sorted arr: "+Arrays.toString(arr));
	}
}
