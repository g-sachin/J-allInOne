package com.sachin.pratice.programs;

public class StringRelated {

	public static void main(String[] args) {
		new StringRelated().find();
		new StringRelated().check();
	}

	private void find() {

		String input = "abcNjhgAhGjhfhAljhRkhgRbhjbevfhO";
		String output = "NAGARRO";
		
		char inputArr[] = input.toCharArray();
		
		int count = 0;
		for(char ch : inputArr){
			if(output.charAt(count) == ch)
				count++;
		}
	    System.out.println(" count length: "+count);
	}

	//input contains in output as well as in same sequence
	//sort return false while port return true
	private void check(){
		String input = "support";
		String output = "port";
		
		for(int i=0; i<input.length(); i++){
			if(input.charAt(i) == output.charAt(0)){
				if(isEquals(output, input.substring(i, i+output.length())))
					return;
			}
		}
	}
	
	private boolean isEquals(String w1, String w2){
		for(int i=0; i<w1.length(); i++){
			if(w1.charAt(i) != w2.charAt(i))
				return false;
		}
		return true;
	}
}
