package com.sachin.pratice.programs.multithreading.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {

	private ExecutorService fixedThreadPool;
	
	public FixedThreadPool(){
		//fixedThreadPool = Executors.newSingleThreadExecutor();
		//fixedThreadPool = Executors.newCachedThreadPool(); //- connect to device; dies automatically after 1 min of inactivity
		//fixedThreadPool = Executors.newScheduledThreadPool(3);// - scheduleAtFix rate for checking JMS queue status; check connection every 1 sec 
		fixedThreadPool = Executors.newFixedThreadPool(3);
	}
	public static void main(String[] args) {
		new FixedThreadPool().startTask();
		System.out.println("main ended...");
	}

	private void startTask() {
		for(int i=0 ; i<7; i++){
			fixedThreadPool.execute(new Thread(new Task()));
		}
		//fixedThreadPool.shutdown(); //shutdown after executing all task..otherwise thread pool will alive forverve
	}
}

class Task implements Runnable {

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName()+" task started..");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}