package com.sachin.pratice.java8.lambda;

public class Lambda {

	private static String test = "Something";
	public static void main(String[] args) {
		lambda();
	}

	private static void lambda() {
          MyFuncational inf = () -> {
        	  System.out.println("Lamda without Args: "+test);
          };
          System.out.println(inf.getClass());
          System.out.println(inf);
          inf.foo();
	}
}

interface MyFuncational {
	
	void foo();
}