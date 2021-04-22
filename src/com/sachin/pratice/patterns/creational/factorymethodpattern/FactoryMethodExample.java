package com.sachin.pratice.patterns.creational.factorymethodpattern;

public class FactoryMethodExample {

	public static void main(String[] args) {
		Car car = CarFactory.manufacureCar("AUD");
		car.addEngineType();
	}
}

class CarFactory {
	public static Car manufacureCar(String carType) {
		Car car = null;
		switch(carType) {
		case "AUDI":
			car = new Audi();
			break;
		case "TESLA":
			car = new Tesla();
		}
		return car;
	}
	
}

abstract class Car{
	abstract void addEngineType();
}

class Tesla extends Car {

	@Override
	public void addEngineType() {
		System.out.println(" TESLA engine added to car");
	}
	
}


class Audi extends Car{

	@Override
	public void addEngineType() {
		System.out.println("AUDI A5 Engine added to car");
		
	}
	
}

