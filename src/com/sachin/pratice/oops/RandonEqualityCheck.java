package com.sachin.pratice.oops;

public class RandonEqualityCheck {

	public static void main(String[] args) {
		new RandonEqualityCheck().check();
	}

	private void check() {
		String s1="abc";
		String s2="abc";
		System.out.println("instance check: "+(s1==s2));
		System.out.println("eual check: "+s1.equals(s2));
		
		int i=47;
		int j=47;
		System.out.println("int instance: "+(i==j));
		
		Integer i1=44;
		Integer i2=44;
		System.out.println("INTEGER instance check: "+(i1==i2));
		System.out.println("INTEGER equal check: "+i1.equals(i2));
	}
}
