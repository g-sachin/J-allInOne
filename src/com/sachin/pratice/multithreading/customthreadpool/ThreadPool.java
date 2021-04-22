package com.sachin.pratice.multithreading.customthreadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

	private BlockingQueue<Runnable> queue = null;
	List<WorkerThread> threadList = new ArrayList<>();

	public ThreadPool(int noOfTask) {
		queue = new LinkedBlockingQueue<Runnable>(9);
		for(int i=0; i<noOfTask ; i++){
			threadList.add(new WorkerThread(queue));
		}
		
		for(WorkerThread thread: threadList){
			thread.start();
		}
	}
	
	public void execute(Runnable task){
		queue.add(task);
	}
}
