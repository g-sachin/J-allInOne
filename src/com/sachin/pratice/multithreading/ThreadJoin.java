package com.sachin.pratice.multithreading;

/**
 * The primary use of Thread.join() is to wait for another thread and start
 * execution once that Thread has completed execution or died. Join is also a
 * blocking method, which blocks until the thread on which join has called die
 * or specified waiting time is over.
 * 
 * @author GUR40832
 *
 */
public class ThreadJoin {

	public static void main(String[] args) {
		final Thread T1 = new Thread(new Runnable() {
			  
            @Override
            public void run() {
                System.out.println("Starting 1");
                System.out.println("Ending 1");
            }
              
        });
          
        final Thread T2 = new Thread(new Runnable() {
  
            @Override
            public void run() {
                System.out.println("Starting 2");
                try {
                    T1.join ();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("Ending 2"); 
            }
              
        });
          
          
        Thread T3 =  new Thread(new Runnable() {
  
            @Override
            public void run() {
                System.out.println("Starting 3");
                try {
                    T2.join ();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                 
                System.out.println("Ending 3"); 
            }
              
        });
         
        // Starting's are random 
        T3.start ();
        T2.start ();
        T1.start ();
         
		// Endings are always 1,2,3
	}
}
