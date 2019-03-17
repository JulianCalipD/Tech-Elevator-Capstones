package com.techelevator;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.techelevator.file.reader.FileReader;



public class Inventory {

	private Map<String, List<Item>> inventoryMap;

	public Inventory() {
		this.inventoryMap = new LinkedHashMap<String, List<Item>>();
	}

	public Map<String, List<Item>> fillInventory(){

		FileReader fileReader = new FileReader();
		

		List<String> inventoryList;
		try {
			inventoryList = fileReader.readFile();

			for (String items : inventoryList) {
				String[] parts = items.split("\\|");

				List<Item> namePriceList = new ArrayList<Item>();

				Item item = new Item(items, items, 0);
				
				if (parts[0].contains("A")) {
					for (int i = 0; i < 5; i++) {
						namePriceList.add(new Chips(parts[1], parts[2], 5));
					}
					inventoryMap.put(parts[0], namePriceList);
				}
				if (parts[0].contains("B")) {
					for (int i = 0; i < 5; i++) {
						namePriceList.add(new Candy(parts[1], parts[2], 5));
					}
					inventoryMap.put(parts[0], namePriceList);
				}
				if (parts[0].contains("C")) {
					for (int i = 0; i < 5; i++) {
						namePriceList.add(new Drinks(parts[1], parts[2], 5));
					}
					inventoryMap.put(parts[0], namePriceList);
				}
				if (parts[0].contains("D")) {
					for (int i = 0; i < 5; i++) {
						namePriceList.add(new Gum(parts[1], parts[2], 5));
					}
					inventoryMap.put(parts[0], namePriceList);
				}

			}
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return inventoryMap;
	}
	
	public Map<String, List<Item>> getInventoryMap() {
		return inventoryMap;
	}

	public void setInventoryMap(Map<String, List<Item>> inventoryMap) {
		this.inventoryMap = inventoryMap;
	}

	}

	
	