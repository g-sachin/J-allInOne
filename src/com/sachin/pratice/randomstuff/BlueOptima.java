package com.sachin.pratice.randomstuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BlueOptima {
	public int i = 0;

	public static void main(String[] args) {
		// int i = 2;

		findLongestSubsString();
		/*
		 * for(int i=0;i<arr.length;i++) { program(arr[i]); }
		 */

		/*
		 * try { badM(); } catch(Exception ex) { System.out.println("D"); } finally {
		 * System.out.println("F"); } System.out.println("E");
		 */
	}

	
	private static void findLongestSubsString() {
		int arr[] = { 2, 1, 3, 6, 1, 2 };
		int result[] = new int[arr.length];
		for(int i=0; i<arr.length;i++) {
			int varArr[] = new int[i+1];
			for(int j=0; j<i+1;j++) {
				varArr[j] = arr[j];
			}
			//System.out.println(Arrays.toString(varArr));
			result[i] = program(varArr);
		}
		System.out.println(Arrays.toString(result));
	}

	private static int program(int... array) {
		ArrayList list = new ArrayList();
		ArrayList longestList = new ArrayList();
		int currentMax;
		int highestCount = 0;
		for (int i = 0; i < array.length; i++) {
			currentMax = Integer.MIN_VALUE;
			for (int j = i; j < array.length; j++) {
				if (array[j] > currentMax) {
					list.add(array[j]);
					currentMax = array[j];
				}
			}
			// Compare previous highest subsequence
			if (highestCount < list.size()) {
				highestCount = list.size();
				longestList = new ArrayList(list);
			}
			list.clear();
		}
		System.out.println("longest substring: "+longestList.toString());
	
		return longestList.size();
	}

	public static int findBS(int... array) {
		ArrayList list = new ArrayList();
		ArrayList bsList = new ArrayList();
		int currentMax;
		int highestCount = 0;
		for (int i = 0; i < array.length; i++) {
			currentMax = Integer.MIN_VALUE;
			for (int j = i; j < array.length; j++) {
				if (array[j] > currentMax) {
					list.add(array[j]);
					currentMax = array[j];
				}
			}
			// Compare previous highest subsequence
			if (highestCount < list.size()) {
				highestCount = list.size();
				bsList = new ArrayList(list);
			}
			list.clear();
		}
		// Print list
		return bsList.size();
	}

	private static List<Integer> check(int... array) {
		ArrayList list = new ArrayList();
		ArrayList longestList = new ArrayList();
		int currentMax;
		int highestCount = 0;
		for (int i = 0; i < array.length; i++) {
			currentMax = Integer.MIN_VALUE;
			for (int j = i; j < array.length; j++) {
				if (array[j] > currentMax) {
					list.add(array[j]);
					currentMax = array[j];
				}
			}

			// Compare previous highest subsequence
			if (highestCount < list.size()) {
				highestCount = list.size();
				longestList = new ArrayList(list);
			}
			list.clear();
		}
		System.out.println();

		// Print list
		Iterator itr = longestList.iterator();
		System.out.println("The Longest subsequence");
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();
		System.out.println("Length of LIS: " + highestCount);
		return longestList;
	}

	private static void badM() throws Exception {
		// TODO Auto-generated method stub
		// throw new Exception();
		// System.out.println(2+ 4+ 5+"");
		// System.out.println(3 + 4 + 4);
		throw new Error();
	}
}

class sub extends BlueOptima {
	public sub() {
		i = 2;
	}
}
