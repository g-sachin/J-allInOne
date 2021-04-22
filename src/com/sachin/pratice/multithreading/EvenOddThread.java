package com.sachin.pratice.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * SOLUTION Approach
 * 
 * We will use wait and notify to solve how to print even and odd numbers using
 * threads in java.
 * 
 * Use a variable called boolean odd. If you want to print odd number, it’s
 * value should be true and vice versa for even number. Create two
 * methods(printOdd and printEven), one will print odd numbers and other will
 * print even numbers. Create two threads, one for odd and one for even. t1 will
 * call printEven method and t2 will call printOdd method simultaneously. If
 * boolean odd is true in printEven method, t1 will wait. If boolean odd is
 * false in printOdd method, t2 will wait.
 * 
 * @author GUR40832
 *
 */
public class EvenOddThread {

	private boolean isOdd = true;

	public static void main(String[] args) {

		EvenOddThread obj = new EvenOddThread();

		EvenThread even = new EvenThread(obj, true);
		OddThread odd = new OddThread(obj, false);

		even.start();
		odd.start();
	}

	public void printEven(int num) {
		synchronized (this) {
			while (isOdd) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Even: " + num);
			isOdd = true;
			notify();
		}
	}

	public void printOdd(int num) {
		synchronized (this) {
			while (!isOdd) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Odd: " + num);
			isOdd = false;
			notify();
		}
	}
}

class EvenThread extends Thread {

	private EvenOddThread mainObj;
	private boolean isEven;
	private Lock lock = new ReentrantLock();

	public EvenThread(EvenOddThread mainObj, boolean isEven) {
		this.mainObj = mainObj;
		this.isEven = isEven;
	}

	public void run() {
		for (int i = 2; i <= 10; i = i + 2) {
			mainObj.printEven(i);
		}
	}

}

class OddThread extends Thread {

	private EvenOddThread mainObj;
	private boolean isOdd;

	public OddThread(EvenOddThread mainObj, boolean isOdd) {
		this.mainObj = mainObj;
		this.isOdd = isOdd;
	}

	public void run() {
		for (int i = 1; i <= 10; i = i + 2) {
			mainObj.printOdd(i);
		}
	}

}
