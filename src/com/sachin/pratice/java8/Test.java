package com.sachin.pratice.java8;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Test {
	int i=4;
	public static void main(String[] args) {
		System.out.println("rkejl");

		int i=9;
		new Test().test();
		System.out.println("dine");
	}

	public void test() {
		try {
			System.exit(0);
		} finally {
			System.out.println("dfgdj");
		}
		
		BigInteger b1 = new BigInteger("555");
		Optional<Long> o = new ArrayList<Long>().stream().min((Long a, Long b) ->a.compareTo(b));
		Set<Long> samples = new HashSet<>();
		samples.add(1L);
		
		
		
		
		
	}
	
	{
		int i=5;
	}
	
	static {
		int i=6;
	}
	
	static class staticclass{ //Test$staticclass
		
	}
	
	class inner { //Test$inner.class
		
	}
}

class outside { //outside.class
	
}
