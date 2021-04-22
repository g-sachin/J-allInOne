package com.sachin.pratice.programs.multithreading;

import java.util.concurrent.Semaphore;

/**
 * Semaphores

    - can be restricts the number of user to particular resource or group resource
    - locks limit only one user per resource
    - semaphore can restricts any no of users to resource

 * @author GUR40832
 *
 */
public class SemaphoreExample {

	Semaphore sem = new Semaphore(1); // N permits are available; other wait till permit is released e.g parking
	public static void main(String[] args) {
		new SemaphoreExample().test();
	}

	private void test() {

		Runnable t1 = () -> {
			mutualExlucsion();
		};
		
		Runnable t2 = () -> {
			mutualExlucsion();
		};
		
	   new Thread(t2).start();
	   //new Thread(t2).start();
	   //new Thread(t2).start();
	   //new Thread(t2).start();
	   new Thread(t1).start();
	}
	
	public void mutualExlucsion() {
		try {
			sem.acquire();
			System.out.println(Thread.currentThread().getName()+" has ACQUIRED lock.");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sem.release();
			System.out.println(Thread.currentThread().getName()+" has RELEASED lock.");
		}
	}
}

//Output
/*Thread-0 has ACQUIRED lock.
  Thread-0 has RELEASED lock.
  Thread-1 has ACQUIRED lock.
  Thread-1 has RELEASED lock.
*/


///SEMAPHORE vs LOCK differences
//- semaphore doesn't have notion of thread - any semaphore can release other semaphores
//- many thread can acquire permit
//- same thread can acquire permit multiple times by initialing semaphore(N)
//- binary semaphore initialized with 1 is not reentrant