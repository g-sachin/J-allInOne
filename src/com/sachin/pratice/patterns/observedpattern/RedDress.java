package com.sachin.pratice.patterns.observedpattern;

import java.util.ArrayList;
import java.util.List;

public class RedDress implements Observable {
	private int price;
	List<Observer> users = new ArrayList<>();

	public void setInStock(int price){
		this.price = price;
		notifyObserver();
	}
	
	@Override
	public void notifyObserver() {
		System.out.println("Notifying users..");
		for (Observer obs : users) {
			obs.update(price);
		}
	}

	@Override
	public void registerObserver(Observer obs) {
		users.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		users.remove(obs);
	}
}
