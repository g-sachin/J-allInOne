package com.sachin.pratice.programs.multithreading.customthreadpool;

import java.util.concurrent.BlockingQueue;

/**
 * Pool Thread
 * 
 * @author GUR40832
 *
 */
public class WorkerThread extends Thread {

	BlockingQueue<Runnable> queue = null;
	public WorkerThread(BlockingQueue<Runnable> queue) {
		this.queue = queue;
	}

	public void run() {
		while(true){
			try {
				Runnable task = queue.take();
				task.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
