package com.sachin.pratice.programs.multithreading;

import java.util.Vector;

/**
 * Real life exaple- Repair-car thread and Accept-car-service thread
 * 
 * @author GUR40832
 *
 *	https://www.baeldung.com/java-wait-notify
 */
public class ProduceConsumerExample {

	public static void main(String[] args) {
		Vector sharedQ = new Vector();
		User u = new User(sharedQ);
		u.start();

		Mechanic me = new Mechanic(sharedQ);
		me.start();
	}
}

class User extends Thread {
	Vector queue = null;

	public User(Vector sharedQ) {
		this.queue = sharedQ;
	}

	public void run() {
		synchronized (queue) {
			queue.add(1);
			notify();
		}
	}
}

class Mechanic extends Thread {
	Vector queue;

	public Mechanic(Vector sharedQ) {
		this.queue = sharedQ;
	}

	public void run() {
		while (queue.isEmpty()) {
			synchronized (queue) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		queue.remove(0);
	}
}
