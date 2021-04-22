package com.sachin.pratice.multithreading;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LoopComplexity {

	public static void main(String[] args) {
		check();
	}

	private static void check() {
		Calendar calendar = Calendar.getInstance();
		System.out.println("Seconds in current minute = " + calendar.get(Calendar.SECOND));
		//Or, use SimpleDateFormat:
		SimpleDateFormat formatter = new SimpleDateFormat("ss");
		System.out.println("Seconds in current minute = " + formatter.format(new Date()));
		
		int ch = 04%1;
		System.out.println("modula: "+ch);
		long start =System.currentTimeMillis();
		for(int i=0;i<1000;i++){
			//System.out.println(i);
		}
		long end =System.currentTimeMillis();
		System.out.println("Time "+(end-start));
		
		long se = (new Date().getTime())/1000;
		System.out.println("time "+se);
	}
}
