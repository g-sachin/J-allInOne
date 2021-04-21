package com.sachin.pratice.programs.multithreading;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockDeadlock {

	  private static ReentrantLock lock = new ReentrantLock(true);
 
	  public static void main(String[] args)  {
		try {
			new LockDeadlock().check();
		}catch(Exception ex){
			System.out.println("exception");
			ex.printStackTrace();
		}
		  
	}

	private void check() throws Exception {
		System.out.println("applying transaction...");
		lock.isFair();
		if(lock.tryLock(10, TimeUnit.MILLISECONDS)){
	        try {
	        	System.out.println("[thread #%d ] acquired lock.");
	        	throw new Exception();
				//Thread.sleep(5000);
	          } catch (Exception e) {
	        	  System.out.println("could not apply transaction: " + e.getMessage());
	            throw e;
	          } finally {
	            try {
	            	System.out.println("finally started...");
	              //throw new RuntimeException();//this.maapi.finishTrans(transId);
	            } catch (Exception e) {
	            	System.out.println("unable to finish transaction #");
	              //throw e;
	            }
	            lock.unlock();
	            System.out.println("[thread #%d ] released lock");
	          }

		} else {
			System.out.println("not acquired lock");
		}
	}
}
