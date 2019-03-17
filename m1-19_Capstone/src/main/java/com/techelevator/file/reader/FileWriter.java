package com.techelevator.file.reader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileWriter {

	public static void main(String[] args) throws IOException, InterruptedException {

		String log = "SalesLog.txt";
		File newFile = new File(log);
		newFile.createNewFile();

	
		
		
		
		try (PrintWriter writer = new PrintWriter(newFile);
				BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
			
			
			String result = "";
			
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			
			
					bufferedWriter.write((dateFormat.format(date))  + "\n");
			}


		
	}
}
