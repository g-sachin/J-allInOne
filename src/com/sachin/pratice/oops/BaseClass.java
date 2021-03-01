package com.sachin.pratice.oops;

public class BaseClass {

	public static void main(String[] args) {
	
		//Derived d  = new Base(); //- compilation error, we can't convert base to derived
		
		BaseClass b = new Derived(); //RTP
	}
}

class Derived extends BaseClass {
	
}