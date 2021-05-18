package com.sachin.pratice.programs.gfg.recursion;

/**
 * Print Nature number using recurstion
 * @author GUR40832
 *
 */
public class PrintNatureNumber {

	public static void main(String[] args) {
		printNto1(5);
		System.out.println("\n------------------   ");
		print1toN(5);

		System.out.println("\n");
		System.out.println("SUM of Natural Nuber: "+sumNaturalNumber(7));
	}
	
	private static void printNto1(int num) {
		if (num == 0)
			return;
		else {
			System.out.print(num);
			printNto1(num-1);
		}
	}
	
	private static void print1toN(int num) {
		if (num == 0)
			return;
		else {
			print1toN(num-1);
			System.out.print(num);
		}
			
	}
	
	private static int sumNaturalNumber(int n) {
		if (n ==0)
			return 0;
		else {
			return n+ sumNaturalNumber(n-1);
		}
	}

}
