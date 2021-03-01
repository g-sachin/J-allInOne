package com.sachin.pratice.patterns.observedpattern.javautil;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ServiceManager implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Observer called...");
		List<String> neList = (List<String>) arg;
		System.out.println("Receivev list:: "+neList.toString());
	}
}
