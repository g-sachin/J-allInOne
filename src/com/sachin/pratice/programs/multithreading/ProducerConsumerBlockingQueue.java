package com.sachin.pratice.programs.multithreading;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerBlockingQueue {

	//bounded queue
	//private final static BlockingQueue<Integer> bQueue = new LinkedBlockingQueue<Integer>(10);
	//unbouded
	private final static BlockingQueue<Integer> bQueue = new LinkedBlockingQueue<Integer>();
	
	public static void main(String[] args) {

		Thread t1 = new Thread(new Producer(bQueue), "Producer");
		Thread t2 = new Thread(new Consumer(bQueue), "Consumer");
		t1.start();
		t2.start();
	}
}


class Producer implements Runnable {
	
	BlockingQueue<Integer> queue = null;
	public Producer(BlockingQueue<Integer> bQueue){
		this.queue = bQueue;
	}

	@Override
	public void run() {
 int count=0;
		while(true){
			Random r =new Random();
			int num = r.nextInt(10);
			try {
				queue.put(num);
				System.out.println("item producesd: "+ ++count);
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	BlockingQueue<Integer> queue = null;
	public Consumer(BlockingQueue<Integer> bQueue){
		this.queue = bQueue;
	}

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(5000);
				int res = queue.take();
				System.out.println(" take: "+res);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
}