package com.sachin.pratice.randomstuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Snapdeal {

	public static void main(String[] args) {
		A a = new B();
		a.m1(); //runtime exception overriding - no effect
		//new Mythread(); //goes into infinite sleep state
		treeSet();
		//Helper h = new Helper(); //error private constructor
		//Outer.main(null);
		float f = 14.6f;
		System.out.println(f%3);
		list();
		system();
		intCheck();
		findNearestSmallest();
		countFreq();
	}

	//count occurance in sorted array
	private static void countFreq(){
		int arr[] = {3, 3, 6, 7, 7, 8, 8, 8, 9};
		int target = 8;
		//O(n) - using Linear Search
		//O(logn) - using Binary Search
		// 1. Find the target element 
		// 2. traverse left and right side to calc count
		int index = binarySearch(arr, target);
		System.out.println("element at index: "+index);
		
		int count = 1;
		int left=index-1;
		int right=index+1;
		
		while(left >= 0 && arr[left] == target){
			left--;
			count++;
		}
		while(right < arr.length && arr[right] == target){
			right++;
			count++;
		}
		System.out.println("occurance of "+target+" is "+count);
	}
	
	private static int binarySearch(int arr[], int target){
		int low = 0;
		int high = arr.length-1;
		
		while(low < high){
			int middle = (low + high)/2;
			if(arr[middle] == target)
				return middle;
			if(target > arr[middle])
				low = middle+1;
			else high = middle -1;
		}
		return -1;
	}
	
	//https://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/
	private static void findNearestSmallest(){
		int arr[] = {1, 6, 4, 10, 2, 5};
		//int arr[] = {4, 5, 2, 10, 8};
		int result[] = new int[arr.length];
		for(int i=0; i< arr.length; i++){
			result[i] = nearest(arr, i);
			//result[i] = smallest(arr, i);
		}
		System.out.println("Arrays: "+ Arrays.toString(result));
	}
	
	private static int smallest(int arr[], int target) {
		int small = Integer.MAX_VALUE;
		for(int i=0; i< target; i++){
			if(arr[i] < arr[target] && small > arr[i]){
				small = arr[i];
			}
		}
		System.out.println("small: "+small);
		return small != Integer.MAX_VALUE ? small : -1;
	}

	private static int nearest(int arr[], int target){
		int small = -1;
		if (target == 0)
			return small;
		for(int i=target; i>=0; i--){
			if(arr[i] < arr[target]){
				small = arr[i];
				break;
			}
		}
		return small;
	}
	
	private static void treeSet(){
		TreeSet<String> tree = new TreeSet<>();
		tree.add("Snap");
		tree.add("snap");
		tree.add("Geeks");
		tree.add("for");
		
		for(String tmp : tree){
			System.out.println(tmp + "");
		}
		System.out.println("\n");
	}
	
	private static void list(){
		List<Integer> list = new ArrayList<>(4);
		list.add(0);
		list.add(1);
		list.add(3);
		list.add(2, 2);
		list.add(3);
		System.out.println(list);
	}
	
	private static void system(){
		System.setProperty("true", "abc");
		System.out.println(Boolean.getBoolean("true"));
	}
	
	private static void intCheck(){
		Integer i1 = 1000;
		Integer i2 = 1000;
		System.out.println(i1.equals(i2));
		System.out.println(i1 == i2);
	}
}


class A {
	void m1() throws ArrayIndexOutOfBoundsException {
		System.out.println("Class A");
	}
}

class B extends A {
	void m1()throws ArrayIndexOutOfBoundsException {
		System.out.println("Class B");
	}
}

class Mythread extends Thread {
	Thread t;
	
	Mythread(){
		t = new Thread(this, "MyThread");
		t.start();
	}
	public void run(){
		try {
			t.join();
			System.out.println(t.getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Helper {
	private int data = 5;
	private Helper(){
		data = 5;
	}
}

class Outer {
	private static int data = 20;
	private static int LocalClass(){
		class Inner {
			public int data = 10;
			private int getData(){
				return data;
			}
		};
		Inner i = new Inner();
		return i.getData();
	}
	
	public static void main(String[] args) {
		System.out.println(data * LocalClass());
	}
}