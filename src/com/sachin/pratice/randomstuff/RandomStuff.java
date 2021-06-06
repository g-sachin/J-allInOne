package com.sachin.pratice.randomstuff;

import java.util.ArrayList;
import java.util.List;

public class RandomStuff {
	String str;
	Boolean b;
	private String getStr(){
		return str;
	}
	
	private void setStr(String str){
		this.str=str;
	}
	public static void main(String[] args) {
		//works on global object
		//pass by refernce works with new object also. thus Java is pass by VAl not ref
		new RandomStuff().checkPassByValue();
		new RandomStuff().testPassByValueOnObject();
		
		//hackerrank();
	}

	private static void hackerrank() {
      long n = 22876792454961L;
      List<Long> list = new ArrayList<>();
      long p=28;
      for(long i=1; i<=n ; i++) {
    	  if(i <0) {
    		  break;
    	  }
		  //System.out.println(i);

    		  
    	  if(n %i ==0) {
    		  list.add(Long.valueOf(i));
    		  System.out.println("TEST-"+i);
    	  }
    		  
      }
      System.out.println("size: "+list.size());
      if (list.size() < p) {
    	  System.out.println(0);
    	  return;
      }
    	  
      System.out.println(list.get((int)p-1));
	}

	private void checkPassByValue() {
		List<String> list = new ArrayList<>();
		list.add("ap1");
		list.add("api1.1");
		list.add("api1.2");
		System.out.println("api1 : "+list.toString());
		testPassByValue(list);
		System.out.println("api 2  : "+list.toString());
	}

	private void testPassByValue(List<String> list) {
		list.add("api2");
		list.add("api2.1");
	}
	
	//https://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value
	private void testPassByValueOnObject(){
		RandomStuff ran = new RandomStuff();
		ran.setStr("api1");
		System.out.println("ran: api 1: "+ran.toString());
		api2PassByValue(ran);
		System.out.println("ran api 2: "+ran.toString());
	}
	
	private void api2PassByValue(RandomStuff ran) {
		//ran.setStr("api 2");
		ran = null;
		ran = new RandomStuff();
		ran.setStr("new str");
	}

	@Override
	public String toString(){
		return "str["+str+"]";
	}
	
}
