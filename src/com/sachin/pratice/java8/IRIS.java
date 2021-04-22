package com.sachin.pratice.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IRIS {

	public static void main(String[] args) {
		String ans = power(0);
		System.out.println("ans: "+ans);
	}

	private static String  power(int num) {
		
		String s = "Hello world!";
		System.out.println(s.substring(6, 12)+s.substring(6, 12));
		System.out.println(s.charAt(1));
		System.out.println("Hello"+"wor");
		System.out.println(Boolean.parseBoolean("faLse"));
		System.out.println("apple".compareTo("banana"));
		return "s";
		/*if (num < 0)
		 return "Wrong Input";
		int exponent = 4;
		int res = 1;
		while(exponent != 0) {
			res *= num;
			--exponent;
		}
		int lastDigit = res %10;
		System.out.println("res: "+res+" and last digit: "+lastDigit);
		return  (lastDigit == num) ? "TRUE" : "FALSE";*/
	}
	
	
	private static void test() {
	  int arr[] = new int[] {3,4,5,7,9};
      List<String> ls = Arrays.stream(arr)
      .mapToObj(x -> Integer.toString(x))
      .collect(Collectors.toList());          
	}
	
	
}

final class Employee {
	private final String name;
	private final long empId;
	private final Address address;
	
	
	public Employee(String name, long empId, Address address) {
		this.name = name;
		this.empId = empId;
		
		Address cloneAddress = new Address();
		cloneAddress.setHouseName(address.getHouseName());
		this.address = cloneAddress;
		
	}
	
	public String getName() {
		return name;
	}
	public long getEmpId() {
		return empId;
	}
	
	public Address getAddress() {
		Address cloneAddress = new Address();
		cloneAddress.setHouseName(this.address.getHouseName());
		return cloneAddress;
	}
}

class Address {
	private String houseName;

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
}
