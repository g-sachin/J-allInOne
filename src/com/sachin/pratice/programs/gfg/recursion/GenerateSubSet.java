package com.sachin.pratice.programs.gfg.recursion;

/**
 * Subset of any String
 * for a length on n; there would be 2^n subsets
 * 
 * I/P: AB
 * O/P: "", "A", "B", "AB"
 * I/P: ABC
 * O/P: "", "A", "B", "C", AB", "BC", "AC", "ABC",  - empty string is also subset 
 * 
 * 
 * I/P: ABCD
 * O/P: "", "A", "B", "C", "D", "AB", "AC", "ABC", "ABD", "ABCD", "BC", "BCD", "CD", "ACD", "AD", "BD"
 * @author GUR40832
 *
 */
public class GenerateSubSet {

	public static void main(String[] args) {
		String str = "ABC";
		String current = "";
		
		subSet(str, current, 0);
	}

	private static void subSet(String str, String current, int index) {
        if(index ==str.length()) {
        	//if(isPalindrome(current))
        	System.out.println(current+" ");
        	return;
        }
		subSet(str, current, index+1);
		subSet(str, current+ str.charAt(index), index+1);
	}
	
	private static boolean isPalindrome(String str) {
		String reverse = new StringBuilder(str).reverse().toString();
		return reverse.equals(str);
	}
}
