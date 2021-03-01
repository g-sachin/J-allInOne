package com.sachin.pratice.java8;

public class SampleParul {

	public static void main(String[] args) {
		new SampleParul().olt();
	}
	
	private void olt (){
		int x = 21;
		int y = 15;
		int olt = x * 48 *4;
		System.out.println("olt: "+olt);
		int cp = y * 4;
		System.out.println("cp "+cp);
		int load = 1+1;
		int result  = olt + cp+load;
		System.out.println("resukt "+result);
				
	}
}

class Customer {
	private boolean hasClubMember;

	public boolean isHasClubMember() {
		return hasClubMember;
	}

	public void setHasClubMember(boolean hasClubMember) {
		this.hasClubMember = hasClubMember;
	}
	
}
