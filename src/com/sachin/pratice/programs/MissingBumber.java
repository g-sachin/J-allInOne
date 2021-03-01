package com.sachin.pratice.programs;

import java.util.Arrays;

public class MissingBumber {

	public static void main(String[] args) {
		new MissingBumber().find();
		new MissingBumber().nMisstingNum();
	}

	private void nMisstingNum() {

		int arr[] = {0, 1, 2, 3, 4, 5, 7, 8, 10};
		int count = 11; //two missing no 6, 9
		
		Arrays.sort(arr);
		for(int i=1; i< arr.length-1;i++){
			if(i != arr[i]){
				System.out.println("Missing no: "+i);
			}
		}
	}

	//(n*n+1)/2
	private void find() {
		int arr[] = {1, 2, 3, 5, 6, 7, 8, 9};
		int arrSum = 0;
		for(int i : arr){
			arrSum +=i;
		}
		int length = arr.length+1;
		int actualSum = (length * (length +1))/2;
		System.out.println("missing num: "+(actualSum - arrSum));
	}
}
