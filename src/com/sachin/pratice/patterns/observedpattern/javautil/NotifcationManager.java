package com.sachin.pratice.patterns.observedpattern.javautil;

import java.util.List;
import java.util.Observable;

public class NotifcationManager extends Observable {
	
	public void sendMessage(List<String> neList){
		//setChanged();
		notifyObservers(neList);
	}

}
