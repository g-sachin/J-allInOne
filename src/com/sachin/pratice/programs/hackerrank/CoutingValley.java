package com.sachin.pratice.programs.hackerrank;

import java.util.Arrays;

public class CoutingValley {
	public static void main(String[] args) {
		//String s="UDDDUDUU";
		//String s = "DDUUDDUDUUUD";
		String s = "DUDUDUDU";
		//countingValleys(s.length(), s);
		
		
		//int arr[] = {0, 0, 1, 0, 0, 1, 0};
		
		  int arr[] = {0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0,
		  0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0,
		  1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1,
		  0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0,
		  0};
		 
		//jumpingOnClouds(arr);
		
		//repeatedString("ceebbcb", 817723);
		 
		int ar[] = {1, 2, 3, 4, 5};
		//rotLeft(ar, 3);
	}
	
	////////////////////////////////////////////////////////////////////////////
	//couting valleys
	static int countingValleys(int n, String s) {
        
		 int valley = 0;
	     int level=0;
	     
	     for(int i=0 ; i< n; i++){
	         level +=  ('U'==s.charAt(i)) ? 1 : -1;
	         
	         if(level == 0 && 'U'==s.charAt(i)) {
	        	 valley++;
	         }
	     }
	     System.out.println("level: "+level);
	     System.out.println("valley : "+valley);
	     return valley;
	    }
	
	////////////////////////////////////////////////////////////////////////
	// Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
    	int pos = 0;
    	int jump = 0;
    	while(pos < c.length) {
    		pos += (pos+2 < c.length && c[pos+2] == 0) ? 2 :1;
    		if(pos < c.length)
    			jump++;
    	}
    	System.out.println("pos: "+pos+" length: "+c.length);
    	System.out.println("jump's: "+jump);
    	return jump;
    }
    
    ///////////////////////////////////////////////////////////////////
    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long words = (long) (n/s.length());
        long remainder = (long) (n % s.length());
        long count=0;
        for(int i=0;i<remainder;i++){
            if('a' == s.charAt(i))
             count++;
        }
        System.out.println("words: "+words+" remainder: "+remainder+" count: "+count +" a's: "+aInStr(s));
        return words*aInStr(s) + count;

    }

    private static int aInStr(String str){
        int count=0;
        for(char ch :  str.toCharArray()){
            if('a' == ch)
              count++;
        }
        return count;
    }

    //////////////////////////////////////////////////////
    // Complete the rotLeft function below.
    static int[] rotLeft(int[] arr, int d) {
        long start = System.currentTimeMillis();
        for(int i=0; i<d;i++){
            int temp = arr[0];
            arr = refillArr(arr, arr.length-1);
            arr[arr.length-1] = temp;
            //System.out.println(" temp: "+temp+ " arr[arr.length-1]: "+arr[arr.length-1]);
            //System.out.println("arr after replacing: "+Arrays.toString(arr));
        }
        long end = System.currentTimeMillis();
        System.out.println("Time taken: "+(end-start));
        System.out.println("final array: "+Arrays.toString(arr));
        return arr;
    }

    private static int[] refillArr(int[] arr, int d){
     for(int i=0; i<d;i++){
        arr[i]=arr[i+1];
     }  
     //System.out.println("arr after shifting: "+Arrays.toString(arr));
    return arr;

    }
    
}
