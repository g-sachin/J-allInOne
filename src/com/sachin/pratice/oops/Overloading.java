package com.sachin.pratice.oops;

import java.io.IOException;

public class Overloading {

	public void a(int a, long b){
		System.out.println("A called...");
	}
	
	public void a(long a, int b){
		System.out.println("B called..");
	}
	public static void main(String[] args) {
		Overloading ol = new Overloading();
		
		//ol.a(4, 5); //-- comiplation error.. amuguity both are of same hierachy.
		
	}
	
	//Return type check
	public Integer foo(int a){
		System.out.println("C called");
		return null;
	}
	
	// compilation error - ambuiguity as retrun type has nothing to do in overloading and compilor treat as same method
	/*public Number foo(int a){
		System.out.println("C with");
		return null;
	}*/
	
	
	//Exception check 
	public void fun(int a) throws Exception{
		
	}
	
	// compilation error - ambuiguity as Exception has nothing to do in overloading and compilor treat as same method
	/*public void fun(int a) throws Exception{
		
	}*/
}
