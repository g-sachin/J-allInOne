package com.sachin.pratice.programs.multithreading.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitWithCallable {
	private ExecutorService submitPool;

	public static void main(String[] args) {
		new SubmitWithCallable().startTask();
	}

	private void startTask() {
		submitPool= Executors.newFixedThreadPool(2);
		List<Future<String>> ls = new ArrayList<>();
		for(int i=0; i <5; i++){
			Future<String>  res = submitPool.submit(new CallableTask());
			ls.add(res);
		}
		for(Future<String> res : ls){
			try {
				if(res.isDone())
				 System.out.println(res.get());
				else 
					System.out.println("not yet completed");
				//res.cancel(true);
			} catch (InterruptedException | ExecutionException e) {
				//ExecutionException wraps the original exception; e.getCause() show original exception
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

class CallableTask implements Callable<String> {

	@Override
	public String call() throws Exception {
		Thread.sleep(100);
		System.out.println(Thread.currentThread().getName()+ "running.");
		//throw new Exception();
		return "sachin";
	}
	
}
