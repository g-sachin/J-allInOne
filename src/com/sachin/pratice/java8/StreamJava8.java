package com.sachin.pratice.java8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamJava8 {
	public static void main(String[] args) {
		new StreamJava8().desc();
		List<String> dates = Arrays.asList("22 Mar 1952", "20 may 2051", "16 mar 2022", "11 aug 1989");
		sortDates(dates);
		
		sortDate_java7(dates);
		//Streams API
		dates.stream().filter(x -> x=="2").count();
		
		filter();
		map();
		flatMap();
		collect();
		foo();
	}

	private static void collect() {
		// TODO Auto-generated method stub
		
		
	}

	private static void flatMap() {
		// TODO Auto-generated method stub
		List<String> ls = Arrays.asList("sa", "re", "ga", "ma");
		ls.stream()
		.flatMap(s -> Stream.of(s.toUpperCase()))
	    .forEach(x -> System.out.println(x));
		
	}

	private static void map() {
		// TODO Auto-generated method stub
		Stream<String> stm = Arrays.asList("Sachin", "Grover", "Priya", "srivastava").stream();
		stm
		.map(str -> str.toUpperCase())
		.sorted()
		.forEach(x -> System.out.println(x));
	}

	private static void filter() {
		// TODO Auto-generated method stub
		Stream.of(1, 2, 4, 6, 7, 8, 4, 9, 11)
		.filter(x -> x%2 == 0)
		.forEach((x) -> { 
		System.out.println(x);});
	}

	private void desc() {
		List<String> artist = Arrays.asList("arijit", "eminem", "papon");
		// Tradition way to calc count
		int count = 0;
		for (String str : artist) {
		}
	}

	public static List<String> sortDates(List<String> dates) {
		SimpleDateFormat f = new SimpleDateFormat("dd MMM yyyy");
		List<String> sorted = dates.stream().sorted((a, b) -> {
			try {
				//System.out.println("java 8 compare: "+f.parse(a).compareTo(f.parse(b)));
				return f.parse(a).compareTo(f.parse(b));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return 0;
		}).collect(Collectors.toList());

		System.out.println("dates: " + sorted.toString());
		return sorted;
	}
	
	public static void sortDate_java7(List<String> dates) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
		Collections.sort(dates, new Comparator<String>() {
			public int compare(String s1, String s2) {
				try {
					System.out.println("comapte: "+sdf.parse(s1).compareTo(sdf.parse(s2))+" s1: "+s1+" s2: "+s2);
					return sdf.parse(s1).compareTo(sdf.parse(s2));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return 0;
			}

			
		});
		System.out.println("java sorted list: "+dates.toString());
	}
	
	public static void foo() {
		List<String> ls = new ArrayList<String>();
		ls.add("sachin");
		ls.add("grover");
		
		Arrays.asList("priya", ls.get(0), ls.get(1), "sr");
		
		List<String> finalList = new ArrayList<>();
		finalList.add("priya");
		finalList.addAll(ls);
		finalList.add("sr");
		
		System.out.println(finalList.toString());
		
	}
}
