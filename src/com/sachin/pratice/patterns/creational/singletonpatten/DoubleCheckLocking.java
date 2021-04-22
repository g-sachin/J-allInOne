package com.sachin.pratice.patterns.creational.singletonpatten;

/**
 * This approach improves performace as threads do not have to wait for lock if
 * object is already created. Also there is no chance of multiple object
 * creation as we are having null check inside synchronized block as well.
 * 
 * @author GUR40832
 *
 */
public class DoubleCheckLocking {

	public static DoubleCheckLocking instance = null;

	private DoubleCheckLocking() {

	}

	public DoubleCheckLocking getInstance() {
		if (instance == null) {
			synchronized (DoubleCheckLocking.class) {
				if (instance == null)
					instance = new DoubleCheckLocking();
			}
		}
		return instance;
	}
}
