package com.sachin.pratice.programs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicate {

	public static void main(String[] args) {
		new RemoveDuplicate().removeDubsFromArray();
		new RemoveDuplicate().removeUsingCollection();
	}

	private void removeUsingCollection() {
		List<Integer> list = Arrays.asList(1,12,6,9,4,1,10,3,5);
		System.out.println("list: with duplicates: "+list.toString());
		
		Set<Integer> set = new HashSet<Integer>(list);
		System.out.println("set without dups: "+set.toString());
	}

	private void removeDubsFromArray() {

		int arr[] = {1,12,6,9,4,1,10,3,5,9,5,3,8,12,1,10,31,55,78,4,65,23,4,8};

		int output[] = new int[arr.length];
		for(int i=0;i<arr.length;i++){
		
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]==arr[j])
					System.out.println("dupls is: "+arr[j]);
			}
		}
	}
}
