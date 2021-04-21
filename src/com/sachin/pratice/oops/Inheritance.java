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
		Inheritance inh = new InheritanceChild();
		System.out.println("str: "+inh.getName().toString());
		System.out.println(inh.a); // print 200 from parent class
		//This is because variables in Java do not follow polymorphism and overriding 
		//is only applicable to methods, not variables. And when an instance variable
		//in a child class has the same name as an instance variable in a parent class,
		//then the instance variable is chosen from the reference type.
		
		
		Parent p = new Child();
		p.foo();
		
	}
	
}


class InheritanceChild extends Inheritance {
	int a=100;
	
}

/// Polymorphism example

class Parent {
	public void foo() {
		System.out.println("Parent class foo");
	}
}

class Child extends Parent {
	public void foo() {
		System.out.println("child class foo.");
	}
	
	public void childAPI() {
		System.out.println("Child class API");
	}
}
