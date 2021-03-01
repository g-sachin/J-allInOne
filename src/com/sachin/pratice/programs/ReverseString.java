package com.sachin.pratice.programs;

public class ReverseString {

	public static void main(String[] args) {
		new ReverseString().reverse();
		new ReverseString().reverseRecursilly("sachin");
	}

	private String reverseRecursilly(String str) {
		if(str.length() < 2)
			return str;
		return reverseRecursilly(str.substring(1)) + str.charAt(0);
		
	}

	private void reverse() {
		String str = "sachin";
		char arr[] = str.toCharArray();
		StringBuilder reverseStr = new StringBuilder();
		for(int i=arr.length-1 ; i >= 0 ; i--){
			reverseStr.append(arr[i]);
		}
		System.out.println("reversed: "+reverseStr.toString());
	}
}
