package com.sachin.pratice.programs.karumachi.searching;

/**
 * Let A be an array of  distinct integers. Suppose A has the following property: there
   exists an index 1 \< K \< n such that A[1]...A[K] is an increasing sequence and A[K+1]....A[n] is a decreasing sequence.
   Design and analyze an efficient algorithm for finding K
 
 * @author GUR40832
 *
 * Bitonic search.
	An array is biotonic if it is comprised of an increasing sequence of integers followed immediately
	by a decreasing sequence of integers. Given a bitonic array A of n distinct integers, describe how
	to determine whether a given integer is in the array in O(logn) steps.
 */
public class P25_A1Ak_FindK {

	public static void main(String[] args) {
		new P25_A1Ak_FindK().usingBinarySearch(); //O(nlogn)
	}

	/**
	 * Lets us assume that the given array is sorted but starts with negative numbers and ends with
	   positive numbers [such functions are called monotonically increasing function]. In this array find
	   the starting index of the positive numbers. Let us assume that we know the length of the input
	   array. Design a O(nlogn) algorithm.
	 */
	private void usingBinarySearch() {
		int arr[] = {-134, -120, -94, -78, -42, -21, -19, -4, -3, -1, 34, 123, 167, 45, 2};
		int result = Integer.MIN_VALUE;
		int low = 0;
		int high = arr.length-1;
		int mid ;
		while(low <= high){
			mid =(low+high)/2;
			
			if((arr[mid-1] < arr[mid]) && (arr[mid] > arr[mid+1])){
				result = arr[mid];
				break;
			}
			else if(arr[mid-1] < arr[mid] && arr[mid] < arr[mid+1])
				low =mid+1;
			else if (arr[mid-1] > arr[mid] && arr[mid] > arr[mid+1])
				high  = mid-1;
		}
		System.out.println("Result is: "+result);
	}
}
