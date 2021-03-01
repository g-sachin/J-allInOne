package com.sachin.pratice.patterns.singletonpattern;

public class EagerInitilization {

	private static EagerInitilization instance = new EagerInitilization();

	private EagerInitilization() {

	}

	public static EagerInitilization getInstance() {
		return instance;
	}
}
