package com.sachin.pratice.programs.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//7515267971
public class ArrayManipluation {
	static String fileName = "D:\\arraymanipulation.txt";

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(fileName);
		new ArrayManipluation().boooom(sc);
	}
	
	private void boooom(Scanner sc) {
		System.out.println(sc.nextInt());
	}
}
