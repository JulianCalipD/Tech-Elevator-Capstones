package com.techelevator;

public class Money {

	private int amountOfQuarters;
	private int amountOfDimes;
	private int amountOfNickels;
	private double feedMoney;
	private double balance;
	private double change;
	private double purchaseAmount;

	public int makeChangeQuarters(double changeMoney) {
		 amountOfQuarters = (int)(changeMoney * 100 / 25);
		return amountOfQuarters;
	}
	public int makeChangeDimes(double changeMoney) {
		 amountOfQuarters = (int)(changeMoney * 100 / 25);
		 int quartersInHundred = amountOfQuarters * 25;
		 int changeMoneyToInt = (int)(changeMoney * 100) ;
		 amountOfDimes = (changeMoneyToInt - quartersInHundred) / 10;
		return amountOfDimes;
	}
	public int makeChangeNickels(double changeMoney) {
		 amountOfQuarters = (int)(changeMoney * 100 / 25);
		 int quartersInHundred = amountOfQuarters * 25;
		 int changeMoneyToInt = (int)(changeMoney * 100) ;
		 amountOfDimes = (changeMoneyToInt - quartersInHundred) / 10;
		 int dimesInHundred = amountOfDimes * 10;
		 amountOfNickels = (changeMoneyToInt - quartersInHundred - dimesInHundred )/ 5;
		 
		 return amountOfNickels;
	}
	
	public void moneyIn(double feedMoney) {

		balance += feedMoney;

		
	}
	public void purchaseAmountIn(double thisPurchaseAmount) {

		purchaseAmount += thisPurchaseAmount;

		
	}
	public void endTransactionSetToZero() {
		balance = 0;
	}

	public double getFeedMoney() {
		return feedMoney;
	}

	public double getBalance() {
		return balance;
	}
	public double getPurchaseAmount() {
		return purchaseAmount;
	}
	
	
}

