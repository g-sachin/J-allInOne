package com.sachin.pratice.patterns.observedpattern;

public class ObserverMainTest {

	public static void main(String[] args) {
		Observer appUser = new AppUser();
		Observer webUser = new WebUser();
		
		RedDress dress =  new RedDress();
		dress.registerObserver(appUser);
		dress.registerObserver(webUser);
		
		dress.setInStock(2322);
		
	}
}
