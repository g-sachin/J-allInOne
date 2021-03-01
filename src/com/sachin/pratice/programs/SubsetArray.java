package com.sachin.pratice.programs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SubsetArray {

	public static void main(String[] args) {
		System.out.println(new SubsetArray().calc());
		System.out.println(new SubsetArray().usingHash());
	}

	private boolean usingHash() {
		int arr1[] = {11, 1, 13, 31, 3, 7};
		int subset[] = {11, 3, 7, 1};

		Set<Integer> set = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
		/*
		 * Set<Integer> set = new HashSet<>(); for(int i=0; i<arr1.length;i++){
		 * set.add(arr1[i]); }
		 */		
		for(int j=0;j<subset.length;j++){
			if(!set.contains(subset[j]))
				return false;
		}
		return true;
	}

	private boolean calc() {

		int arr1[] = {11, 1, 13, 31, 3, 7};
		int subset[] = {11, 3, 7, 1, 5};
		
		int j=0;
		for(int i=0;i<subset.length;i++){
			for(j=0;j<arr1.length;j++){
				if(arr1[j] == subset[i])
					break;
			}
			if(j==arr1.length)
				return false;
		}
		return true;
		
		//System.out.println("arr: "+Arrays.toString(subset));
	}
}
