package com.sachin.pratice.patterns.creational.singletonpatten;

public class EagerInitilization {

	private static EagerInitilization instance = new EagerInitilization();

	private EagerInitilization() {

	}

	public static EagerInitilization getInstance() {
		return instance;
	}
}
