package com.sachin.pratice.programs.multithreading;

/**
 * The ThreadLocal class in Java enables you to create variables that can only
 * be read and written by the same thread. Thus, even if two threads are
 * executing the same code, and the code has a reference to a ThreadLocal
 * variable, then the two threads cannot see each other's ThreadLocal variables.
 * 
 * @author GUR40832
 *
 */
public class ThreadLocalExample {

	public static void main(String[] args) {

		Thread t1 = new Thread(new CThread());
		Thread t2 = new Thread(new CThread());
		
		t1.start();
		t2.start();
		
		try {
			t2.join();
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class CThread extends ThreadLocal<String> implements Runnable {

	private ThreadLocal<Integer> tlocal = new ThreadLocal<Integer>();
	
	/*@Override
	protected String initialValue() {
		// TODO Auto-generated method stub
		return super.initialValue();
	}*/
	
	@Override
	public String initialValue() {
		return "XYZ";
	};

	@Override
	public void run() {
		tlocal.set((int) (5 * (Math.random())));
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("val: "+tlocal.get()+ "thread; "+Thread.currentThread().getName());
	}
}