package com.sachin.pratice.programs.multithreading;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *               |
 *               |
 *               train A
 *               |
 *               |
 *               |
 * ---train B----|------------------------------
 *               |
 *               |
 *               |
 *               |
 *               |
 * 
 * Train A acquired Lock A, then Lock B to cross intersection
 * Train B acquired lock B, then Lock A to cross intersection
 * 
 * due to this - deadlock occurs since train A is waiting for lock B but it was already acquired by train B
 * 
 * Resolution - implement locking ordering in proper manner
 * Train A has to acquired lock A then lock B
 * and similar way Train B also has to acquire lock A then lock B.
 * 
 * @author GUR40832
 *
 */
public class DeadlockExample {
	
	public static void main(String[] args) {
		Intersection ins = new Intersection();
		TrainA a = new TrainA(ins);
		TrainB b = new TrainB(ins);
		
		a.start();
		b.start();

	}

	static class Intersection {
		private Object roadALock = new Object();
		private Object roadBLock = new Object();

		public void takeRoadA() {
			synchronized (roadALock) {
				System.out.println("Road A is locked by thread: " + Thread.currentThread().getName());

				synchronized (roadBLock) {
					System.out.println("Acquired Road B lock by thread: " + Thread.currentThread().getName());
				}
			}
		}

		public void takeRoadB() {
			synchronized (roadBLock) {
				System.out.println("Road B is locked by thread: " + Thread.currentThread().getName());

				synchronized (roadALock) {
					System.out.println("Acquired Road A lock by thread: " + Thread.currentThread().getName());
				}
			}
		}
	}
	
	static class TrainA extends Thread {
		private Intersection ins;
		public TrainA(Intersection ins) {
			this.ins = ins;
		}
		
		public void run() {
			while (true) {
				try {
					Thread.currentThread().setName("TRAIN-A");
					Thread.sleep(new java.util.Random().nextInt(4));
					
					ins.takeRoadA();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
static class TrainB extends Thread {
		
		private Intersection ins;
		public TrainB(Intersection ins) {
			this.ins = ins;
		}
		
		public void run() {
			while(true) {
				try {
					Thread.currentThread().setName("TRAIN-B");
					Thread.sleep(new java.util.Random().nextInt(4));
					
					ins.takeRoadB();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
}
