package com.techelevator;

import java.util.List;
import java.util.Map;

public class VendingMachineActual {

	private Menu menu;
	Money money = new Money();
	Inventory inventory = new Inventory();
	boolean isChips = false;
	boolean isCandy = false;
	boolean isGum = false;
	boolean isDrink = false;

	Map<String, List<Item>> map;

	
	
	public VendingMachineActual(Menu menu) {
		this.menu = menu;
		
}

	public void fillUp() {
		map = inventory.fillInventory();
	}
	public void Transaction(String selection){
	
	for (Map.Entry<String, List<Item>> entry : map.entrySet()) {
		List<Item> items = entry.getValue();
		Item item = items.get(0);
		if (selection.equals(entry.getKey())) {
			
			
			
//			String selectionName = item.getItemName();
		
			
			if (item.getItemCount() == 0) {
				boolean isSoldOut = true;
				menu.printOutIsSoldOut(isSoldOut);
				break;
			}
			if (item.getItemCount() > 0) {
				item.decreaseQuantity();
				money.purchaseAmountIn(Double.parseDouble(item.getItemPrice()));
				menu.printOutItemCount(item.getItemCount());
				menu.printOutBalance(money.getBalance());
				menu.printOutChargeTotal(money.getPurchaseAmount());
				break;
		}
		menu.printOutNotValid();
	}
	}
}public boolean whatIsProduct(String selection) {		
	if (selection.substring(0 , 1).equals("A")){

	return	isChips = true;
	}
	if (selection.substring(0 , 1).equals("B")) {

	return	isCandy = true;
		
	}
	if (selection.substring(0 , 1).equals("C")) {

	return	isDrink = true;

	}
	if (selection.substring(0 , 1).equals("D")) {

	return isGum = true;
	} else {
		return false;
	}
	

}
}
