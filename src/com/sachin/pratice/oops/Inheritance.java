package com.sachin.pratice.oops;

public class Inheritance {

	int a = 200;
	private String name;
	
	public String getName(){
		return "sachin";
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	
	public static void main(String[] args) {
		Inheritance inh = new Child();
		System.out.println("str: "+inh.getName().toString());
		System.out.println(inh.a);
	}
}

class Child extends Inheritance {
	int a=100;
	
}

