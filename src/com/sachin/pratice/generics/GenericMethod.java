package com.sachin.pratice.generics;

//https://www.journaldev.com/1663/java-generics-example-method-class-interface#java-generic-method
public class GenericMethod {

	
//	///https://stackoverflow.com/questions/3923081/java-generics-and-the-number-class
	public <T extends Number> void add(T x, T y) {
		if (x instanceof Float)
			 x.floatValue();
		//return x+y;
	}
}
