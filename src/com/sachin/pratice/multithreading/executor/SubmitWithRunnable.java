package com.sachin.pratice.multithreading.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitWithRunnable {

	private ExecutorService threadPool = Executors.newFixedThreadPool(5);
	public static void main(String[] args) {
		new SubmitWithRunnable().startTask();
	}
	
	private void startTask() {

		Future<?> f = threadPool.submit(new RunnableTask());
		try {
			System.out.println(f.get()); //null - runable run doesn't return
		} catch (InterruptedException | ExecutionException e) { 
			//If we don't make the call to the get() method of Future class – then the exception thrown
			//by call() method will not be reported back, and the task will still be marked as completed:
			e.printStackTrace();
		}
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