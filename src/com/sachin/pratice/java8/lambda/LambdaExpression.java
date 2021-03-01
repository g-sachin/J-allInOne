package com.sachin.pratice.java8.lambda;

import java.util.Comparator;

public class LambdaExpression {

	public static void main(String[] args) {
		
		Comparator<String> lambdaComparator = (s1, s2) -> s1.compareTo(s2);
		int res = lambdaComparator.compare("hello", "hi");
		System.out.println(res);
		
		
		FunctionalInterfaces fn = () -> System.out.println("no args Lambda");
		
		fn.apply();
		
		MultiArgsInterface multi = (s1, i) -> {
			if(s1 != null)
			return i;
			return 0;
		};
		
		
		int rs = multi.apply(null, 4);
		System.out.println("args res: "+rs);
	}
}


@FunctionalInterface
interface FunctionalInterfaces {
	
	void apply();
	
	//void func();
}


interface MultiArgsInterface {
	
	int apply(String s1, int i);
}