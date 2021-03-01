package com.sachin.pratice.programs.fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * There are several ways to read a plain text file in Java e.g. you can use
 * FileReader, BufferedReader or Scanner to read a text file. Every utility
 * provides something special e.g. BufferedReader provides buffering of data for
 * fast reading, and Scanner provides parsing ability. Read more:
 * http://javarevisited.blogspot.com/2016/07/10-examples-to-read-text-file-in-java.html#ixzz54RdMmL4q
 * 
 * @author GUR40832
 *
 */
public class FileReaderExample {

	final String filePath = "D:\\eclipse\\mars\\Nonsense-oct\\src\\com\\sachin\\pratice\\programs\\fileio\\data.txt";
	public static void main(String[] args) {
		try {
			new FileReaderExample().fileReader();
			new FileReaderExample().bufferedreader();
		} catch (IOException e) {
			e.printStackTrace();
		};
	}

	private void fileReader() throws IOException {
		FileReader fs  = new FileReader(filePath);
		int ch;
		while((ch = fs.read())!= -1){
			System.out.println("FileReader out: "+(char)ch);
		}
		fs.close();
	}

	private void bufferedreader() throws IOException {
		System.out.println("file path: "+filePath);
		FileReader fs  = new FileReader(filePath);
		BufferedReader bs = new BufferedReader(fs);
		String output = bs.readLine();
		while(output != null){
			System.out.println("out: "+output);
			output = bs.readLine();
		}
		fs.close();
		bs.close();
	}
}
