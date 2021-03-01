package com.sachin.pratice.programs.multithreading.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitWithRunnable {

	private ExecutorService threadPool = Executors.newFixedThreadPool(1);
	public static void main(String[] args) {
		new SubmitWithRunnable().startTask();
	}
	
	private void startTask() {

		Future<?> f = threadPool.submit(new RunnableTask());
	}
}

class RunnableTask implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" task started..");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}