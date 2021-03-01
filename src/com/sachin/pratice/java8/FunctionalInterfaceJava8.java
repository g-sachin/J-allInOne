package com.sachin.pratice.java8;

@FunctionalInterface
public interface FunctionalInterfaceJava8 {

	public void read(String filePath);

	default void readFile(String fileType, String filePath) {

	}

	static FunctionalInterfaceJava8 csvInterface() {
		return filePath -> {

		};
	}
}

// https://www.javacodemonk.com/sapient-fee-calculator-coding-problem-in-java-3ebd1a21