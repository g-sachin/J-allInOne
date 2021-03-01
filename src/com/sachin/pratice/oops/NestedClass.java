package com.sachin.pratice.oops;

public class NestedClass {

	private static String outerStatic = "Outer-static";

	private String nonStatic = "nonStatic";

	public static void staticApi() {
		System.out.println("Inside static API");
	}

	public void nonStaticApi(){
	System.out.println("Non-static Api");	
	}
	
	public static void main(String[] args) {
		NestedClass outer = new NestedClass();
	}

	static class StaticInnerClass {
    
		public static void main(String[] args) {
			staticApi();
		}

		public void display(){
			
		}

	}
	
	class InnerClass {

	}
}
