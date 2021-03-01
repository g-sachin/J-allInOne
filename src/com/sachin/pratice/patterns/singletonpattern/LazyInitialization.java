package com.sachin.pratice.patterns.singletonpattern;

/**
 * it leads us to bad performance as only one thread can access getInstance()
 * method at a time even though critical section is only one line (line 24)
 * where instance is being created.
 * 
 * For Example, In above code, as Thread T1 is inside getInstance() method,
 * other threads T2, T3, T4 has to wait until T1 completes its execution of
 * getInstance() method. It reduces performance drastically.
 * 
 * @author GUR40832
 *
 */
public class LazyInitialization {

	private static LazyInitialization instance = null;

	private LazyInitialization() {

	}

	// Lazy initialization is done when client first time request for the instance
	public static synchronized LazyInitialization getInstance() {
		if (instance == null) {
			instance = new LazyInitialization(); // Critical section
		}
		return instance;
	}

}
