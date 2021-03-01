package com.sachin.pratice.programs;

public class Palindrome {

	public static void main(String[] args) {

		new Palindrome().find();
		new Palindrome().palindrome(); //O(logn)
	}

	private void find() {

		String str = "shaahs";
		
		StringBuilder sb = new StringBuilder();
		char ch[] = str.toCharArray();
		for(int i=ch.length-1; i>=0;i--){
			sb.append(ch[i]);
		}
		System.out.println(sb.toString());
		System.out.println(str.equals(sb.toString()));
	}
	
	private void palindrome() {
		String str = "shaahs";
		
		for(int i=0, j=str.length()-1; i<str.length()/2;i++, j--) {
			if(str.charAt(i) != str.charAt(j)) {
				System.out.println("Not palindrome");
				break;
			}
				
		}
	}
	
}
