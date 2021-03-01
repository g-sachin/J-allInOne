package com.sachin.pratice.oops;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NestedClassExcer {

	static String str="";
	static{
		str="sachin";
		System.out.println("outer static block");
	}
	
	public NestedClassExcer(){
		str = "grover";
		System.out.println("outer c'tor");
	}

	{
		System.out.println("anomnoy block");
	}
	class Inner {
		 {
			System.out.println("inner class");
		}
	}
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//Class c = Class.forName("com.sachin.pratice.oops.NestedClassExcer");
		NestedClassExcer ss = new NestedClassExcer();
		System.out.println("static var: "+str);
		/*c.newInstance();
		//c.newInstance();
		Map<String, String> map = new HashMap<>();
		map.put("1", "abc");
		Iterator<String> itr = map.keySet().iterator();
		while(itr.hasNext()){
			String kk = itr.next();
			System.out.println(kk);
			System.out.println(map.get(kk));
		}*/
		
	}
}
