package com.sachin.pratice.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Aeris {
	public static void main(String[] args) {
	       int arr1[] = {4, 9, 5};
	       int arr2[] = {9, 4, 9, 8, 4, 5};

		
		System.out.println("Intersection "+test(arr1, arr2));
	}

	private static List<Integer> test(int arr1[], int arr2[]) {
       Map<String, Integer> map =  new HashMap<>();
       for(int i=0; i< arr1.length; i++) {
    	   for(int j=0; j<arr2.length; j++) {
    		   if(arr1[i] == arr2[j]) {
    			   String key = arr2[j]+"-"+j;   
    			   map.put(key, j);
    			   break;
    		   }
    	   }
       }
       
       System.out.println(map.toString());
       List<Integer> result = new ArrayList<>();
       for(Entry<String, Integer> entry: map.entrySet()) {
    	   String val = entry.getKey().split("-")[0];
    	   result.add(Integer.parseInt(val));
    	   
       }
       
       return result;
	}
	
	
	


}
