package com.sachin.pratice.multithreading;

/**
 * A simple case for wait-notify example.
 * 
 * Wait-Notify example Real work example of Bank system, withdraw and deposit
 * money
 * 
 * @author GUR40832
 *
 */
public class WaitNotifyExample {

	private int actualAmount = 1000;

	public void withdrawMoney(int amount) {
		if (actualAmount < amount) {
			synchronized (this) {
				try {
					//wait shall always be in while loop. otherwise incorrect result.
					//e.g if withdrwa amount[5000] is more the deposit[2000], then after deposit notify thread will 
					//woke up waiting thread and actual amount becomes negative.
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		this.actualAmount -= amount;
		System.out.println("Money afterwitdrwa: " + actualAmount);
	}

	public void depositMoney(int money) {
		this.actualAmount += money;
		synchronized (this) {
			notify();
		}
		System.out.println("Money after deposit: " + actualAmount);
	}

	public static void main(String[] args) {
		WaitNotifyExample example = new WaitNotifyExample();
		
		WaitThread wait = new WaitThread(example);
		wait.start();
		
		NotifyThread notify = new NotifyThread(example);
		notify.start();

	}
}

class WaitThread extends Thread {
	WaitNotifyExample example = null;

	public WaitThread(WaitNotifyExample example) {
		this.example = example;
	}

	@Override
	public void run() {
		System.out.println("withdrwa money started...");
		//example.withdrawMoney(2000);
		example.withdrawMoney(5000);
	}
}

class NotifyThread extends Thread {
	WaitNotifyExample example = null;

	public NotifyThread(WaitNotifyExample example) {
		this.example = example;
	}

	@Override
	public void run() {
		System.out.println("deposit money started...");
		example.depositMoney(2000);
	}
}