package com.sachin.pratice.programs.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SparseArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//new SparseArray().tingtong(sc);
		new SparseArray().check();
	}

	private void check() {
      int l=3;
      int r=9;

      int[]arr = new int[14];
      List<Integer> list =new ArrayList<>();
      int count=0;
      for(int i=l ; i<=r;i++){
    	  if(i%2 != 0){
    		  arr[count] = i;
    		  count++;
    	  }
    		  
    		  //list.add(i);
      }
      System.out.println("sss "+Arrays.toString(arr));
      //System.out.println("array: "+Arrays.toString(list.toArray()));
	}

	private void tingtong(Scanner sc) {
		System.out.println(sc.nextInt());
		System.out.println(sc.nextLine());
		System.out.println(sc.nextLine());
		System.out.println(sc.nextLine());
		System.out.println(sc.nextLine());
		System.out.println(sc.nextInt());
	}
}


/**
ArrayList<String> a = new ArrayList<String>();
Scanner scan = new Scanner(System.in);
int n = scan.nextInt();
for(int i = 0; i < n; i++) {
    a.add(scan.next());
}
int q = scan.nextInt();
for(int i = 0; i < q; i++) {
    int count = 0;
    String s = scan.next();
    for(String str : a) {
        if(str.equals(s))
            count++;
    }
    System.out.println(count);
}*/