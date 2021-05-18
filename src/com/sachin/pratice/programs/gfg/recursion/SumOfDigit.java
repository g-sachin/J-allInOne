package com.sachin.pratice.programs.gfg.recursion;

/*
 * Sum of digit  - 243 => 9,  5753=> 20
 */
public class SumOfDigit {
	public static void main(String[] args) {
         int res = sumOfDigit(5743);
         System.out.println("SUM is "+res);
	}

	private static int  sumOfDigit(int i) {
       if(i ==0)
    	   return 0;
       else {
    	   return i%10 + sumOfDigit(i/10);
       }
	}
}
