package com.techelevator;
import org.junit.*;
import static org.junit.Assert.*;

public class TestMoney {

	private Money target;
	
	@Before
	public void setup() {
		
	target = new Money();	
		
	}
	@After
	public void cleanup() {
		
	}
	
	@Test
	public void rightAmountOfQuarters() {
		double changeMoney = 0.95;
		
		Assert.assertEquals(3, target.makeChangeQuarters(changeMoney));
		
		
	}
	@Test
	public void rightAmountOfDimes() {
		double changeMoney = 0.95;
		
		Assert.assertEquals(2, target.makeChangeDimes(changeMoney));
		
		
	}
	@Test
	public void rightAmountOfNickels() {
		double changeMoney = 0.05;
		
		Assert.assertEquals(1, target.makeChangeNickels(changeMoney));
		
		
	}
}
