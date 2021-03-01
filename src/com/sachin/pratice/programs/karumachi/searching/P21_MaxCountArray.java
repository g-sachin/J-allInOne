package com.sachin.pratice.programs.karumachi.searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class P21_MaxCountArray {

	public static void main(String[] args) {
		new P21_MaxCountArray().bruteForce(); // O(n2)
		new P21_MaxCountArray().sortedArr(); //O(nlogn)  ???
		new P21_MaxCountArray().usingHash();
	}

	private void usingHash() {
		int arr [] = {2,6, 19, 5, 3, 5, 2, 2, 5, 9, 6, 3};
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i: arr){
			if(map.containsKey(i)){
				int count = map.get(i);
				map.put(i, ++count);
			} else {
				map.put(i, 1);
			}
		}
		
		System.out.println("Map: "+map.toString());
		int max = Integer.MIN_VALUE;
		int key = 0;
		for(Entry<Integer, Integer> entry : map.entrySet()){
			
			if(entry.getValue() > max){
				max = entry.getValue();
				key = entry.getKey();
			}
		}
		System.out.println("Highest count for: "+key+" is: "+max);
	}

	private void sortedArr() {
		int arr [] = {2,6, 19, 5, 3, 5, 2, 2, 5, 9, 6, 3};
		Arrays.sort(arr);
		
		System.out.println("sorted array: "+Arrays.toString(arr));
		int count=0;
		int max = Integer.MIN_VALUE;
		int index = 0;
		for(int i=0 ; i< arr.length-1; i++){
			if(arr[i] == arr[i+1])
				count++;
			if(count > max){
				index = i;
				max = count;
			}
		}
		//System.out.println("Max count is: "+max+ " for number: "+arr[index]);
	}

	private void bruteForce() {
		int arr [] = {2,6, 19, 5, 3, 5, 2, 2, 5, 9, 6, 3};
		int max=Integer.MIN_VALUE;
		int index = 0;
		
		for(int i=0; i<arr.length; i++){ //O(n)
			int count = 0;
			for(int j=i; j<arr.length; j++){ //O(n)
				if(arr[i] == arr[j]){
					count++;
				}
			}
			if(count > max){
				index = i;
				max = count;
			}
		}
		System.out.println("Max count is: "+max+ " for number: "+arr[index]);
	}
	
}
