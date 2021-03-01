package com.sachin.pratice.patterns.observedpattern;


public class AppUser implements Observer {

	@Override
	public void update(int price) {
		System.out.println("Appuser price:: "+price);
	}

}
