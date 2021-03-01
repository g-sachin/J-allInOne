package com.sachin.pratice.oops;

public class MedthodIOverriding extends Base{

	public static void foo(){
		System.out.println("a");
	}
	
	public static void main(String[] args) {
		MedthodIOverriding drived = new MedthodIOverriding();
		
		Base b = new MedthodIOverriding();
		
		drived.foo();
		b.foo();
	}
}

class Base {
	public static void foo(){
		System.out.println("b");
	}
}