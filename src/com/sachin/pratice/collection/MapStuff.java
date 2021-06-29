package com.sachin.pratice.collection;

import java.util.ArrayList;
import java.util.List;

public class MapStuff {
	public static void main(String[] args) {
		//testNumber();
		//fibonacci(7);
		evenFibonacci(3);
	}

	private static void fibonacci(int n) {
          // 1, 2, 3, 5, 8, 13, 21, 
		int sum;
		int first = 1;
		int second = 2;
		if(n >= 1)
			System.out.println(first);
		if(n >= 2)
			System.out.println(second);
		
		for(int i=2; i< n; i++) {
			sum = first + second;
			System.out.println(sum);

			first = second;
			second = sum;
		}
	}
	
	private static void evenFibonacci(int n) {
        // 1, 2, 3, 5, 8, 13, 21, 
		List<Integer> list = new ArrayList<>();
		int sum;
		int first = 1;
		int second = 2;
		/*if(n >= 1 && isEven(n))
			System.out.println(first);
		if(n >= 2 )
			System.out.println(second);*/
		
		if(isEven(first))
		  list.add(first);
		if(isEven(second))
		  list.add(second);
		for(int i=2; i<Integer.MAX_VALUE; i++) {
			sum = first + second;
			if(isEven(sum))
			 list.add(sum);
			if(list.size() >= n)
				break;
			//System.out.println(sum);

			first = second;
			second = sum;
		}
		
		System.out.println(list.toString());
		/*long res = list.stream()
		    .filter(num -> num %2 ==0)
		    .red*/
		long res = 0;
		for(int i: list) {
			if(i % 2 == 0)
				res = res + i;
		}
		System.out.println(res);
	}
	
	private static boolean isEven(int num) {
		return num % 2 == 0;
	}

	private static void testNumber() {
		for(int i=1; i<=100; i++) {
			System.out.print(i);			
			if(i % 3 == 0)
				System.out.print(" A");
			if(i %5 == 0){
				System.out.print(" B");
			}
			System.out.println("\n");
		}
		
	}
}
