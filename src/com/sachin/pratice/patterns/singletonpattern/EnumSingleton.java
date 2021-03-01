package com.sachin.pratice.patterns.singletonpattern;

public class EnumSingleton {

	public static void main(String[] args) {
		System.out.println(Singleton.INSTANCE);

	}

	enum Singleton {
		INSTANCE;
		private Singleton() {
			// TODO Auto-generated constructor stub
		}

		private void getID() {

		}
	}
}

//http://codepumpkin.com/breaking-singleton-using-reflection-and-enum-singleton/

/**
 * ENUM Pros
 * 
 * 1. any enum value is instantiated only once in a Java program.
 * 2. We cannot manually invoke enum constructor from Java Program. JVM handles the creation
 * and invocation of enum constructors internally.
 * 3. it is not possible to call enum constructor from the program, it is not possible for us to access them
 * by Reflection also. Hence, reflection can’t break singleton property in case
 * of enums.
 * 4. Enum Singleton cannot be broken using Serialization and Enums
 * are also by default thread-safe.
 * 
 * 
 * Cons 1. enums do not support lazy loading.
 */