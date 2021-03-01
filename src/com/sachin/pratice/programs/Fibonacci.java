package com.sachin.pratice.programs;

public class Fibonacci {

	public static void main(String[] args) {
		new Fibonacci().iterative(8);
		System.out.println("res: "+new Fibonacci().recursive(9));
	}

	private int recursive(int input) {
	
		if(input == 0 || input == 1)
			return 1;
		return recursive(input-1) + recursive(input-2);
	}

	private void iterative(int input) {
		StringBuilder sb = new StringBuilder();
	
		int f1=1;
		int f2=1;
		int res=0;
		res = f1+f2;
		sb.append(f1);
		sb.append(f2);
		
		sb.append(res);
		for(int i=2;i<input;i++){
  
			f1=f2;
			f2=res;
			res=f1+f2;
			sb.append(res);
		}
		System.out.println(sb.toString());
	}
}
