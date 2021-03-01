package com.sachin.pratice.programs;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

//find first non repeated character of a given String?
public class NonRepeated {

	public static void main(String[] args) {
		new NonRepeated().find();
		new NonRepeated().conventionalWay();
	}

	private void conventionalWay() {
		String str = "GeeksforGeeks";
		char count[] = new char[200];
		System.out.println("empty arr: "+Arrays.toString(count));
		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i)]++;
		}
		System.out.println("Char array: " + Arrays.toString(count));

		for (int i = 0; i < str.length(); i++) {
			if (count[str.charAt(i)] == 1) {
				System.out.println("first no-repeate: " + str.charAt(i));
				break;
			}
		}
	}

	// using collection
	private void find() {
		// String str = "GeeksforGeeks"; //f
		String str = "GeeksQuiz"; // G

		char arr[] = str.toCharArray();
		Map<Character, Integer> map = new LinkedHashMap<>();
		for (char ch : arr) {
			if (map.get(ch) != null) {
				int count = map.get(ch);
				map.put(ch, count + 1);
			} else {
				map.put(ch, 1);
			}
		}
		System.out.println("Sorted map: " + map.toString());
		for (Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				System.out.println("first non repated char: " + entry.getKey());
				break;
			}
		}

		System.out.println("index: " + str.charAt(0));
	}
}
