package com.sachin.pratice.patterns.creational.factorymethodpattern;

public class FactoryPADTECExample {
	public static void main(String[] args) {
		ServiceValidator val = OtuServiceValidatorFactory.createValidator("CREATE");
		val.validate();
	}

}


class OtuServiceValidatorFactory {
	
	private static ServiceValidator validator;
	public static ServiceValidator createValidator(String type) {
		if(type == "CREATE") {
			validator = new CreateOtuServiceValidator();
		}
		
		return validator;
	}
	
}

interface ServiceValidator{
	public void validate();
}

abstract class OtuServiceValidator implements ServiceValidator{
	
}

class CreateOtuServiceValidator extends OtuServiceValidator {
	@Override
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