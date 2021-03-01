package com.sachin.pratice.patterns.observedpattern;

public class WebUser implements Observer {

	@Override
	public void update(int price) {
		System.out.println("WEB-User price:: "+price);
	}

}
