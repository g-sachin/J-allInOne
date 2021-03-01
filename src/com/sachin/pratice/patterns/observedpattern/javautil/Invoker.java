package com.sachin.pratice.patterns.observedpattern.javautil;

import java.util.Arrays;
import java.util.List;

public class Invoker {

	private NotifcationManager notifManager;
	private ServiceManager sm;
	Invoker(){
	     sm = new ServiceManager();
	     notifManager = new NotifcationManager();
		 notifManager.addObserver(sm);
	}
	
	public static void main(String[] args) {
		Invoker inv = new Invoker();
		inv.pushMessage(Arrays.asList("one", "two"));
	}

	private void pushMessage(List<String> neList) {
		notifManager.sendMessage(neList);
	}
}
