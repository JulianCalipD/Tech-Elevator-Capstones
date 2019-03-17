package com.techelevator;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;
	
	Money money = new Money();
	Item item = new Item(null, null, 0);
	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while(choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if(selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch(NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if(choice == null) {
			out.println("\n*** "+userInput+" is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for(int i = 0; i < options.length; i++) {
			int optionNum = i+1;
			out.println(optionNum+") "+options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}
	public void printOutSoundChips(boolean isChips) {
		
		if(isChips) {
			System.out.println("Crunch Crunch, Yum!");
		}
		
	}
	public void printOutSoundCandy(boolean isCandy) {
		
		if(isCandy) {
		System.out.println("Munch Munch, Yum!");
		}
	}
	public void printOutSoundDrink(boolean isDrink) {
		
		if(isDrink) {
		System.out.println("Glug GLug, Yum!");
		}
	}
	public void printOutSoundGum(boolean isGum) {
		
		if(isGum) {
		System.out.println("Chew Chew, Yum!");
		}
	}
	public void promptEnterAmount() {
		System.out.println("Enter the amount of USD you want to feed: $(1), $(2), $(5), or $(10)");
	}
	public void promptSelection() {
		System.out.print("Make a selection: ");
	}
	public void printOutFeedMoreMoney() {
		System.out.println("Please feed more money...");
	}
	public void printOutNotValid() {
		System.out.println("**Not a valid option**");
	}
	public void printOutIsSoldOut(boolean isSoldOut) {
		if(isSoldOut) {
			System.out.println("Sorry, that item is sold out.");
		}
	}
	public void printOutBalance(double vendingMoney) {
		
		System.out.printf("Current Balance : $%-4.2f",  vendingMoney);
		
	}
	public void printOutChargeTotal(double priceMoney) {
		
		System.out.printf("\nCost to you : $%-4.2f",  priceMoney);
	}
	public void printOutChange(double changeMoney) {
		System.out.println("Your total quarters: " + money.makeChangeQuarters(changeMoney));
		System.out.println("Your total dimes: " + money.makeChangeDimes(changeMoney));
		System.out.println("Your total nickels: " + money.makeChangeNickels(changeMoney));
	}
	public void printOutItemCount(int itemCount) {

		System.out.println(itemCount);
	}
}
