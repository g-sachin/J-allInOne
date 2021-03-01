package com.sachin.pratice.oops;

public class OutOfMemoryScenario {

	public static void main(String[] args) {
		//I. JVM Has Run Out of Native Memory
		check1();
		//II. Java heap is out of memory.
	}

	//1. Scenario 1 - create infinite no of threads
	private static void check1() {

		for(int i=0 ; true; i++){
			new Thread(){
				public void run(){
					try {
						Thread.sleep(100000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}.start();
			
			System.out.println("Thread created: "+i);
		}
	}
}
