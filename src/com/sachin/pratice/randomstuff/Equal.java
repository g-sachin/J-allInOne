package com.sachin.pratice.randomstuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Equal {

	private int in;
	public Equal(int n){
		in=n;
	}
	
/*	@Override
	public boolean equals(Object obj){
	  return true;
	}
*/	public static void main(String[] args) {
		
		Equal e1 = new Equal(2);
		Equal e2 = new Equal(2);
		
		System.out.println(e1==e2);
		System.out.println(e1.equals(e2));
		
		new CThread().start();

		e1.checkIteratorNullCheck();
		
		e1.mapWithDupKey();
	}

	private void mapWithDupKey() {

		class Person {
			int age;
			
			public Person(int age){
				this.age = age;
			}
			public int getAge(){
				return age;
			}
		}
		
		Map<Person, Integer> map = new HashMap<>();
		
		Person p1 = new Person(3);
		Person p2 = new Person(3);
		Person p3 = new Person(3);
		
		map.put(p1,1);
		map.put(p2,1);
		map.put(p3,1);
		
		System.out.println(map.toString());
		
	}

	private void checkIteratorNullCheck() {
		List<Integer> ls = new ArrayList<>();
		
		ls.add(1);
		ls.add(2);
		ls.add(null);
		ls.add(3);
		ls.add(null);
		ls.add(6);
		ls.add(1);
		
		System.out.println(ls.toString());
		
		Iterator<Integer> itr = ls.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
}

class CThread extends Thread {
	
	public void start(){
	  System.out.println("start");	
	}
	
	public void run(){
		System.out.println("run");
	}
}