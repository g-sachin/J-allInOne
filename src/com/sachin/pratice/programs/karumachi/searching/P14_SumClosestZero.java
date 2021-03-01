package com.sachin.pratice.programs.karumachi.searching;

public class P14_SumClosestZero {

	public static void main(String[] args) {
		new P14_SumClosestZero().bruteForce();
	}

	private void bruteForce() {
		//int arr[] = {1, 60, -10, 70, -80, 85 };
		int arr[] = {61, 60, 10, -70, 80, 85 };
		int lowest = Integer.MAX_VALUE;
		int elm1 = 0, elm2 = 0;
		for(int i=0; i<arr.length; i++){
			for(int j=i+1; j<arr.length;j++){
				int diff = arr[i]+arr[j];
				if(Math.abs(diff) < Math.abs(lowest)) {
					lowest = diff;
					elm1 = i;
					elm2 = j;
				}
			}
		}
		System.out.println("lowest diff "+lowest+ " with elements -> "+arr[elm1]+" and "+ arr[elm2]);
	}
}
