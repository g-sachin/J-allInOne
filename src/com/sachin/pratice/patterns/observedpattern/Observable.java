package com.sachin.pratice.patterns.observedpattern;

public interface Observable {

	public void notifyObserver();

	/**
	 * 
	 * @param obs
	 */
	void registerObserver(Observer obs);

	/**
	 * 
	 * @param obs
	 */
	void removeObserver(Observer obs);
}
