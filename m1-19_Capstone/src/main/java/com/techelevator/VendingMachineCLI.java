package com.techelevator;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.file.reader.FileWriter;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private static final String FEED_MONEY = "Feed Money";
	private static final String SELECT_ITEM = "Select Item";
	private static final String FINISH_PURCHASE = "Finish Purchase";
	private static final String[] PURCHASE_MENU_OPTIONS = { FEED_MONEY, SELECT_ITEM, FINISH_PURCHASE };

//	private static final String ONE_DOLLAR = "$1";
//	private static final String TWO_DOLLAR = "$2";
//	private static final String FIVE_DOLLAR = "$5";
//	private static final String TEN_DOLLAR = "$10";
//	private static final String[] DOLLAR_MENU_OPTIONS = { ONE_DOLLAR, TWO_DOLLAR, FIVE_DOLLAR, TEN_DOLLAR };
	
	
	Money money = new Money();
	private String price;
	private Menu menu;
	private int itemCount;
	Scanner scanner = new Scanner(System.in);
	FileWriter writer = new FileWriter();
	VendingMachineActual vend = new VendingMachineActual(menu);
	
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;

	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			
			vend.fillUp();
			
			Map<String, List<Item>> map;

			Inventory inventory = new Inventory();
			map = inventory.fillInventory();
			
			
			boolean isChips = false;
			boolean isCandy = false;
			boolean isGum = false;
			boolean isDrink = false;

			boolean madeSelection = false;
			
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items

				for (Map.Entry<String, List<Item>> entry : map.entrySet()) {
					List<Item> items = entry.getValue();
					Item item = items.get(0);
					System.out.println(entry.getKey() + " " + item.getItemName() + " " + item.getItemPrice());
				}

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

				while (true) {
					String secondChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

					if (secondChoice.equals(FEED_MONEY)) {

						menu.promptEnterAmount();
						String thirdChoice = scanner.nextLine();

						if (thirdChoice.equals("1") || 
								thirdChoice.equals("2") || 
								thirdChoice.equals("5") || 
								thirdChoice.equals("10")) {
							money.moneyIn(Double.parseDouble(thirdChoice));
						} else {
							menu.printOutNotValid();
						}
						menu.printOutBalance(money.getBalance());
					}
					if (secondChoice.equals(SELECT_ITEM)) {

						menu.promptSelection();
						for (Map.Entry<String, List<Item>> entry : map.entrySet()) {
						
							
						String selection = scanner.nextLine();
						if (selection.equals(entry.getKey())) {
						vend.Transaction(selection);
						vend.whatIsProduct(selection);
						}
						}
						
						
//						
//						for (Map.Entry<String, List<Item>> entry : map.entrySet()) {
//							List<Item> items = entry.getValue();
//							Item item = items.get(0);
//							if (selection.equals(entry.getKey())) {
//								
//								
//								
//								String selectionName = item.getItemName();
//							
//								
//								if (item.getItemCount() == 0) {
//									boolean isSoldOut = true;
//									menu.printOutIsSoldOut(isSoldOut);
//								}
//								if (item.getItemCount() > 0) {
//									item.decreaseQuantity();
//									money.purchaseAmountIn(Double.parseDouble(item.getItemPrice()));
//									menu.printOutItemCount(item.getItemCount());
//									menu.printOutBalance(money.getBalance());
//									menu.printOutChargeTotal(money.getPurchaseAmount());
//									
//									if (selection.substring(0 , 1).equals("A")){
//
//										isChips = true;
//									}
//									if (selection.substring(0 , 1).equals("B")) {
//
//										isCandy = true;
//										
//									}
//									if (selection.substring(0 , 1).equals("C")) {
//
//										isDrink = true;
//
//									}
//									if (selection.substring(0 , 1).equals("D")) {
//
//										isGum = true;
//									}
//									break;
//
//								} 
//							}
//							menu.printOutNotValid();
//						}

					}
					if (secondChoice.equals(FINISH_PURCHASE)) {
						if (money.getBalance() >= money.getPurchaseAmount()) {
							double changeMoney = money.getBalance() - money.getPurchaseAmount();
							menu.printOutSoundChips(isChips);
							menu.printOutSoundCandy(isCandy);
							menu.printOutSoundDrink(isDrink);
							menu.printOutSoundGum(isGum);
							menu.printOutChange(changeMoney);
							money.endTransactionSetToZero();
							
							
							
							
						} else {
							menu.printOutFeedMoreMoney();
						}

					}

				}
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}


//	public static String[] getDollarMenuOptions() {
//		return DOLLAR_MENU_OPTIONS;
//	}
}
