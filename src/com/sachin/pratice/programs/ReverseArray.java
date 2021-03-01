package com.sachin.pratice.programs;

import java.util.Arrays;

public class ReverseArray {

	public static void main(String[] args) {
		new ReverseArray().reverse_SingleArray();
		new ReverseArray().reverse_bruteForce();
	}

	//Reverse array: [6, 5, 16, 9, 8, 2, 3, 1, 4]
	private void reverse_SingleArray() {
		int arr[] = {4, 1, 3, 2, 8, 9, 16, 5, 6};
		int middle = arr.length/2;
		int last = arr.length-1;
		for(int i=0 ; i<middle; i++){
			int swap = arr[last];
			arr[last] = arr[i];
			arr[i] = swap;
			
			last--;
		}
		System.out.println("Reverse array: "+Arrays.toString(arr));
	}
	
	//Reverse using another arrays: [6, 5, 16, 9, 8, 2, 3, 1, 4]
	private void reverse_bruteForce(){

		int arr[] = {4, 1, 3, 2, 8, 9, 16, 5, 6};

		int res[] = new int[arr.length];
		int count = 0;
		for(int i = arr.length-1 ; i>=0 ; i--){
			res[count] = arr[i];
			count++;
		}
		
		System.out.println("Reverse using another arrays: "+Arrays.toString(res));
	}
}
