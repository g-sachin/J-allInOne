package com.sachin.pratice.java8.lambda;


public class HigherOrderExample {
	public static void main(String[] args) {
		new HigherOrderExample().test();
	}

	private void test() {
       calculate(4, 5, (a, b) -> System.out.println("ADDITION of "+a+" and "+b+" is:"+ (a+b)));
       //other way to call Higher order
       calculate(4, 5, (a, b) -> add(a, b));
       
       
       //Calculation add = (a, b) -> System.out.println(a+b);
       //add.computation(4, 6);
       
       calculate(4, 5, (a, b) -> System.out.println("ADDITION of "+a+" and "+b+" is:"+ (a-b)));
       
       //calculate(4, 5, (a, b) -> System.out.println("SUBSTRACTION of "+a+" and "+b+"is:"+ a-b));
       //Calculation sub = (a, b) -> System.out.println(a-b);
       //sub.computation(5 , 4);
       
	}
	
	public void add(int a, int b) {
		System.out.println("ADDITION of "+a+" and "+b+" is:"+ (a+b));
	}

	private void calculate(int x, int y, Calculation cal) {
		cal.computation(x, y);
	}
	
}



///CUSTOM Functional interface to compute add/substract/division
@FunctionalInterface
interface Calculation {
	void computation(int a, int b);
}