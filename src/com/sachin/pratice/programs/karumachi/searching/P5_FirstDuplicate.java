package com.sachin.pratice.programs.karumachi.searching;

public class P5_FirstDuplicate {

	public static void main(String[] args) {
		P5_FirstDuplicate fd = new P5_FirstDuplicate();
		fd.bruteForce();
	}

	private void bruteForce() {
		int arr[] = {3,1,2,4,2,3,5};
		for (int i=0;i<arr.length;i++){
			for(int j=i+1; j<arr.length;j++){
				if(arr[i]==arr[j]){
					System.out.println("First duplicate %d "+arr[i]);
				    return;
				}
			}
		}
	}
}
