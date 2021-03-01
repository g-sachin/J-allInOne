package com.sachin.pratice.programs;

public class BinarySearch {
	int[] arr = { 2, 4, 33, 55, 345, 543, 544, 655, 7888, 8999, 12222, 55555 };

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		System.out.println("Pos:: "+bs.binarySearch(55));
	}

	private int binarySearch(int item) {
		int low = 0;
		int high = arr.length - 1;
		int  middle;
		while(low <= high){
			middle = (low + high)/2;
			if(item == arr[middle])
				return middle;
			if(arr[middle] < item)
				low  = middle +1;
			else
				high = middle -1;
		}
		return 0;
	}
}
