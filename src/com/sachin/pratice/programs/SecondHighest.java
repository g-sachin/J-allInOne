package com.sachin.pratice.programs;

public class SecondHighest {

	public static void main(String[] args) {
		new SecondHighest().find();
	}

	private void find() {
			int arr[] = {2, 8, 1,17, 12};
			int high = 0;
			int second = 0;
			for(int i : arr){
				if(i> high)
					high= i;
				if(i > second && i < high)
					second = i;
			}
			System.out.println(high+" , "+second);
		}
}
