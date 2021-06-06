package com.sachin.pratice.programs;

public class LongestSubStringPalindrome {
	public static void main(String[] args) {
		boolean b1 = true;
		boolean b2= false;
		boolean b3= true;
		
		System.out.println(b1&b2 | b2 & b3);
		if(b1 & b2 | b2 & b3 | b2)
			System.out.println("OK");
		if(b1&b2 | b2 & b3 |b2 | b1)
			System.out.println("dokey");
		
		float r =11;
		double res = 3.14*r*r;
		long area = Math.round(res);
		System.out.println("area: "+area);
		
		String s = "b";
		System.out.println(s.charAt(0));
		
		
	}

}
