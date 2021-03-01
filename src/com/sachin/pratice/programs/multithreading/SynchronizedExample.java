package com.sachin.pratice.programs.multithreading;

public class SynchronizedExample {

	public static void main(String[] args) {
		Counter cn = new Counter();
		MyThread t1 = new MyThread(cn);
		MyThread t2 = new MyThread(cn);
		
		t1.start();
		t2.start();
	}
}

class Counter {
	private int count=0;
	public synchronized void add(int val){
		System.out.println("Thread: "+Thread.currentThread().getName());
		//this.count += val;
		count++;
		System.out.println("counter: "+count);
	}
}
class MyThread extends Thread {

	private Counter counter;
	public MyThread(Counter counter) {
		this.counter = counter;
	}

	public void run() {
		System.out.println("Thread started: "+Thread.currentThread().getName());
		for (int i = 0; i < 10; i++) {
			counter.add(i);
		}
	}
}