package com.sachin.pratice.program.codility;

import java.util.ArrayList;
import java.util.List;

public class BitwiseXOR {
	public static void main(String[] args) {
		//new BitwiseXOR().solution(5, 8);
		new BitwiseXOR().test(5, 9);
	}

	private void test(int m, int n) {
		String res = getBinary(m);
		for(int i=m+1;i<=n;i++) {
			res = findXOR(res, getBinary(i));
		}
		System.out.println("res is: "+Integer.parseInt(res, 2));
	}
	
	private String findXOR(String a, String b) {
		String res = "";
		String m = a;
		String l = b;
		// System.out.println("m: "+m+" , n: "+l);
		for (int i = 0; i < m.length(); i++) {
			if (m.charAt(i) != l.charAt(i))
				res = res + "1";
			else
				res = res + "0";
		}

		return res;
		//return Integer.parseInt(res, 2);
	}
	
	//======================================================================
	
	public int solution(int m, int n) {
		// write your code in Java SE
		List<String> list = new ArrayList<>();
		for (int i = m; i <= n; i = i + 2) {
			list.add(calcXOR(i, i + 1));
		}
		for(int i=0; i<list.size(); i=i+2) {
			return calcXORBinary(list.get(i), list.get(i+1));
		}
		/*
		 * while (list.size() > 0) { return calcXORBinary(list.get(0), list.get(1)); }
		 */		return -1;
	}

	private String getBinary(int n) {
		String str = "";
		while (n > 0) {
			int res = n % 2;
			str = res + str;
			n = n / 2;
		}
		String to = "";
		if (str.length() < 6) {
			int add = 5 - str.length();

			while (add > 0) {
				to = "0" + to;
				add--;
			}
		}
		str = to + str;
		// System.out.println("Str: "+str);
		return str;
	}

	private String calcXOR(int a, int b) {
		String res = "";
		String m = getBinary(a);
		String l = getBinary(b);
		// System.out.println("m: "+m+" , n: "+l);
		for (int i = 0; i < m.length(); i++) {
			if (m.charAt(i) != l.charAt(i))
				res = res + "1";
			else
				res = res + "0";
		}
		// System.out.println("res: "+res);
		return res;
	}

	private int calcXORBinary(String a, String b) {
		String res = "";
		String m = a;
		String l = b;
		// System.out.println("m: "+m+" , n: "+l);
		for (int i = 0; i < m.length(); i++) {
			if (m.charAt(i) != l.charAt(i))
				res = res + "1";
			else
				res = res + "0";
		}

		return Integer.parseInt(res, 2);
	}

}
