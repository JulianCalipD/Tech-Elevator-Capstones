package com.techelevator.file.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
  
public class FileReader {

	private String inventoryFile = "vendingmachine.csv";

	public FileReader() {
		this.inventoryFile = inventoryFile;
	}

	public List<String> readFile() throws FileNotFoundException {

		List<String> inventory = new ArrayList<String>();

		File inputFile = new File(inventoryFile);
		try (Scanner fileScanner = new Scanner(inputFile)) {
			while (fileScanner.hasNextLine()) {
				inventory.add(fileScanner.nextLine());
			}
		}
		return inventory;
	}

	public String getInventoryFile() {
		return inventoryFile;
	}

	public void setInventoryFile(String inventoryFile) {
		this.inventoryFile = inventoryFile;
	}

	
}
