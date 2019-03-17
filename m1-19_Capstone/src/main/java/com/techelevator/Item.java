package com.techelevator;

import java.math.BigDecimal;

public class Item {
	
	private String itemName;
	private String itemPrice;
	private int itemCount = 5;
	private String itemSlot;
	
	

	
	
	// Just changed itemPrice from double to string
	public Item(String itemName, String itemPrice, int itemCount) {
		this.itemCount = itemCount;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		//this.itemSlot = itemSlot;
	}
	
	
	
	
	
	
	
	
	public int getItemCount() {
		return itemCount;
	}


	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}


	public String getItemSlot() {
		return itemSlot;
	}


	public void setItemSlot(String itemSlot) {
		this.itemSlot = itemSlot;
	}

	
	public String getItemName() {
		return itemName;
	}

	public String getItemPrice() {
		return itemPrice;
	}


	public void decreaseQuantity() {
		itemCount--;
	}
	
	public boolean isSoldOut() {
		boolean isSoldout = true;
		return isSoldout;
	}
	


	
	

}
