package com.sachin.pratice.programs.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class LeftArrayRotation {

	public static void main(String[] args) {
		new LeftArrayRotation().foo();
		new LeftArrayRotation().bestCase();
	}

	private void foo() {
		int arr [] = new int[]{1, 2, 3, 4, 5};
		int length = arr.length;
		int rotation = 4;
		
		int res[] = {1, 2, 3, 4, 5};
		
		for(int i=0 ; i<rotation ;i++){
			int element = arr[i];
			System.out.println("Element: "+element);
		   for(int j=0; j< length-1; j++){
			   res[j] = res[j+1];
		   }
		   res[length-1]=element;
		   System.out.println("intial : "+Arrays.toString(res));
		}
		
		System.out.println("arrays: "+Arrays.toString(res));
	}

	/**
	 * @author 
	 */
	private void bestCase(){
		/**
		 * @explanation
		 * 
		 * Each time I read an element of the array from the input,
		 * I directly assign it to the array at the speific index after shifting.
		 * 
		 * d left rotations equal (n-d) right rotations. 
		 * 
		 * The array has a size of n,
		 * so when the index (i+n-d) is equal to n, the index actually goes back to the starting index.
		 * I use mod to get the correct index where I want to assign the element when the index is larger than n. 
		 */
		Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int d = scan.nextInt();
        int[] array = new int[n];
        for(int i=0; i<n;i++) {
            array[(i+n-d)%n] = scan.nextInt();
        }
        for(int i=0; i<n;i++) {
            System.out.print(array[i] + " ");
        }
	}
}
