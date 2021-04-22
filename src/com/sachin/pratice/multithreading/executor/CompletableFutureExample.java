package com.sachin.pratice.multithreading.executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

//https://www.callicoder.com/java-8-completablefuture-tutorial/
public class CompletableFutureExample {

	public static void main(String[] args) {
		new CompletableFutureExample().test();
	}

	private void test() {
      CompletableFuture<String> cf = CompletableFuture.supplyAsync(() ->{
    	 return ""; 
      });
      try {
		cf.get();
	} catch (InterruptedException | ExecutionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
      cf.thenAccept( (str) -> System.out.println());
	}
}
