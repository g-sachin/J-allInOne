package com.sachin.pratice.programs.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVReader {

	String fileName = "D:\\eclipse\\mars\\Nonsense-oct\\src\\com\\sachin\\pratice\\programs\\fileio\\sample.csv";
	String compleCSC = "D:\\eclipse\\mars\\Nonsense-oct\\src\\com\\sachin\\pratice\\programs\\fileio\\mixFile.csv";
	public static void main(String[] args) {
		/**
		 *  1,	sachin,	grover,	 Aricent
 	     *	2,	 NMS,	 OTN,	 Aricent
 	     *
		 */
		new CSVReader().readCSV();
		/*	10,AU,Australia
			11,AU,Aus""tralia
			"12","AU","Australia"
			"13","AU","Aus""tralia"
			"14","AU","Aus,tralia"*/ 
		new CSVReader().readComplexCSV();
	}

	private void readCSV() {
		FileReader fs = null;
		BufferedReader bs = null;
		try {
			fs = new FileReader(fileName);
			bs = new BufferedReader(fs);
			
			String str = bs.readLine();
			while(str != null){
 				String arr[] = str.split(",");
 				System.out.println("Id: "+arr[0]+" Name: "+arr[1]+" 2ndName: "+arr[2]+" compnay: "+arr[3]);
 				str = bs.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				fs.close();
				bs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void writeCSV() throws IOException {
		String fileName = "output.csv";
		FileWriter fw = new FileWriter(fileName);
		BufferedWriter bw = new BufferedWriter(fw);
		
		String header = "Cit/Company, amount";
		bw.append(header);
		
		//bw.write( );
	}
	
	private void readComplexCSV() {
		// TODO Auto-generated method stub
		
	}

}
