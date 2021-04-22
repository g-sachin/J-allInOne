package com.sachin.pratice.patterns.creational.factorymethodpattern;

public class FactoryPADTECExample {

}


class OtuServiceValidatorFactory {
	
}

interface ServiceValidator{
	public void validate();
}

abstract class OtuServiceValidator implements ServiceValidator{
	
}

class CreateOtuServiceValidator extends OtuServiceValidator {
	public void validate() {
		System.out.println("CREATE Otu service validator");
	}
	
}

class UpdateOtuServiceValidator extends OtuServiceValidator {

	@Override
	public void validate() {
		System.out.println("UPDATE otu service validator");
	}
	
}

class DeleteOtuServiceValidator extends OtuServiceValidator {

	@Override
	public void validate() {
		System.out.println("DELETE otu service validator");
	}

}