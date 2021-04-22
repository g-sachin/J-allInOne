package com.sachin.pratice.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Example for wait in a main thread
 * How  Main thread goes into waiting state and never woke
 * Analogy - Mediator.java[Padtec]
 * @author GUR40832
 *
 */
public class WaitExample {

	Lock lock =new ReentrantLock();
	public static void main(String[] args) {
		System.out.println("calling API...");
		WaitExample wx = new WaitExample();
		Test test = new Test(wx);
		test.start();
		NotifyJob job = new NotifyJob(wx);
		//new Thread(job).start();
		wx.keepOnWaiting();
		//wx.notifyThread();
		//Below line will never executre, since Main Thread goes into waiting state and never woke up!
		System.out.println("Main method ends...");
	}
	
	//It can never woke up waiting thread by using notify since wait is happening on same thread.
	// TO achieve; call wait and notify using different thread[Inter thread communication]
	private void notifyThread() {
		synchronized(this){
			notify();
		}
	}

	public void keepOnWaiting(){
		System.out.println("Started...@: time: "+System.currentTimeMillis());
		try {
			synchronized (this) {
				System.out.println(Thread.currentThread().getName()+" Obtaining Lock...");
				//Thread.sleep(5000);
				wait();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/**
 * This is to test if Main Thread[one Thread] acquired lock and goes into witing state via wait(),
 * Does Other thread can access the same lock
 * To test does wait really release the lock and other thread can acquire that lock
 * 
 * When the thread waits, it temporarily releases the lock for other threads to use, but it will need it again to continue execution
 * 
 * @author GUR40832
 *
 */
class Test extends Thread {
	WaitExample exs;
	public Test(WaitExample wx) {
		this.exs = wx;
	}

	public void run(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("checking if Main THread is waiting on lock...");
		synchronized(this){
			exs.keepOnWaiting();
		}
		
		System.out.println("Thread - "+Thread.currentThread().getName()+" ended!");
	}
}

class NotifyJob implements Runnable {

	WaitExample exs ;
	public NotifyJob(WaitExample wx) {
		this.exs = wx;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized(exs){
			exs.notifyAll();
		}
	}
	
}