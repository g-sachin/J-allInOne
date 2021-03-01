package com.sachin.pratice.randomstuff;

import java.util.ArrayList;
import java.util.List;

public class Random {
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
		new Random().checkPassByValue();
		new Random().testPassByValueOnObject();
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
	
	private void testPassByValueOnObject(){
		Random ran = new Random();
		ran.setStr("api1");
		System.out.println("ran: api 1: "+ran.toString());
		api2PassByValue(ran);
		System.out.println("ran api 2: "+ran.toString());
	}
	
	private void api2PassByValue(Random ran) {
		//ran.setStr("api 2");
		ran = null;
		ran = new Random();
		ran.setStr("new str");
	}

	public String toString(){
		return "str["+str+"]";
	}
}
