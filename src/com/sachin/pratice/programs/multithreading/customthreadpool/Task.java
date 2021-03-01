package com.sachin.pratice.programs.multithreading.customthreadpool;

public class Task implements Runnable{

	@Override
	public void run() {
		System.out.println("Thread- "+Thread.currentThread().getName()+" started.");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
