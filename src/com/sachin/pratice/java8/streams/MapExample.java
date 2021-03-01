package com.sachin.pratice.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//Map convert stream - 
// .map accepts - Function<T,R> accept type T and return type R has apply function
public class MapExample {

	public static void main(String[] args) {
		upparCase();
		strToIntegerSquare();
	}
	
	private static void upparCase() {
		List<String> list = Arrays.asList("sachin", "grover", "bhiwani", "gurgaon");
		list.stream().map(str -> str.toUpperCase())
		.forEach(System.out::println);
	}
	
	private static void strToIntegerSquare() {
		List<String> list = Arrays.asList("44", "2", "11", "321");
		Stream<Integer> s = list.stream().map(str -> Integer.parseInt(str) * Integer.parseInt(str));
		s.forEach(System.out::println);
	}
	
}
