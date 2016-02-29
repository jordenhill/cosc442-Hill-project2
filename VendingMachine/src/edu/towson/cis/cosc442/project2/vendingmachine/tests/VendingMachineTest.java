/**
 * 
 */
package edu.towson.cis.cosc442.project2.vendingmachine.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.towson.cis.cosc442.project2.vendingmachine.*;

/**
 * @author Jorden
 *
 */
public class VendingMachineTest {

	VendingMachine vendingMachine;
	VendingMachineItem item1 = new VendingMachineItem("Pepsi", 1.50);
	VendingMachineItem item2 = new VendingMachineItem("Mountain Dew", 1.50);
	VendingMachineItem item3 = new VendingMachineItem("Aquafina", 1.50);
	VendingMachineItem item4 = new VendingMachineItem("Brisk", 1.50);

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		vendingMachine = new VendingMachine();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test to see if an item can be added successfully to all slots. 
	 */
	@Test
	public final void testAddItem() {
		assertTrue("Failed to add Pepsi", vendingMachine.addItem(item1, "A"));
		assertTrue("Failed to add Mountain Dew", vendingMachine.addItem(item2, "B"));
		assertTrue("Failed to add Aquafina", vendingMachine.addItem(item3, "C"));
		assertTrue("Failed to add Brisk", vendingMachine.addItem(item4, "D"));
	}
	
	/**
	 * Test to see if an item cannot be be added to an already occupied slot.
	 */
	@Test (expected = VendingMachineException.class)
	public final void testAddItemToOccupiedSlot() {
		vendingMachine.addItem(item1, "A");
		vendingMachine.addItem(item2, "A");
	}

	/**
	 * Test to see if an item cannot be added to a slot that doesn't exist.
	 */
	@Test (expected = VendingMachineException.class)
	public final void testAddItemWithIncorrectCode() {
		vendingMachine.addItem(item1, "E");
	}
	
	/**
	 * Test to see if items can be successfully removed from all slots.
	 */
	@Test
	public final void testRemoveItem() {
		vendingMachine.addItem(item1, "A");
		vendingMachine.addItem(item2, "B");
		vendingMachine.addItem(item3, "C");
		vendingMachine.addItem(item4, "D");
		assertNotNull("Failed to remove Pepsi", vendingMachine.removeItem("A"));
		assertNotNull("Failed to remove Mountain Dew", vendingMachine.removeItem("B"));
		assertNotNull("Failed to remove Aquafina", vendingMachine.removeItem("C"));
		assertNotNull("Failed to remove Brisk", vendingMachine.removeItem("D"));
	}

	/**
	 * Test to see if an item cannot be removed from a slot that doesn't exist.
	 */
	@Test (expected = VendingMachineException.class)
	public final void testRemoveItemWithIncorrectCode() {
		vendingMachine.addItem(item1, "A");
		vendingMachine.addItem(item2, "B");
		vendingMachine.addItem(item3, "C");
		vendingMachine.addItem(item4, "D");
		vendingMachine.removeItem("E");
	}
	
	/**
	 * Test to see if an item cannot be removed from a slot that has nothing assigned to it.
	 */
	@Test (expected = VendingMachineException.class)
	public final void testRemoveItemFromUnassignedSlot() {
		vendingMachine.addItem(item1, "A");
		vendingMachine.addItem(item2, "B");
		vendingMachine.addItem(item3, "C");
		vendingMachine.removeItem("D");
	}
	
	/**
	 * Test to see if an item can be removed twice
	 */
	@Test (expected = VendingMachineException.class)
	public final void testRemoveItemTwice() {
		vendingMachine.addItem(item1, "A");
		vendingMachine.removeItem("A");
		vendingMachine.removeItem("A");
	}
	
	
	/**
	 * Test to see if money can be inserted into the vending machine.
	 */
	@Test
	public final void testInsertMoney() {
		assertTrue("Failed to add money to balance", vendingMachine.insertMoney(2.0));
	}

	/**
	 * Test to see if a negative amount of money cannot be inserted into the vending machine.
	 */
	@Test (expected = VendingMachineException.class)
	public final void testInsertNegativeAmountOfMoney() {
		vendingMachine.insertMoney(-2.0);
	}
	
	/**
	 * Test to see if the balance is what it should be after inserting money.
	 */
	@Test
	public final void testProperBalanceAfterInsertMoney() {
		double initialBalance = vendingMachine.getBalance();
		vendingMachine.insertMoney(3.0);
		assertEquals("Got incorrect balance", initialBalance + 3.0, vendingMachine.getBalance(), 0.01);
	}
	
	/**
	 * Test to see if getBalance() works as intended.
	 */
	@Test
	public final void testGetBalance() {
		vendingMachine.insertMoney(5.0);
		assertEquals("Got incorrect balance back", 5.0, vendingMachine.getBalance(), 0.01);
	}

	/**
	 * Test to see if a purchase can be made from a slot with an item in it and a sufficient balance.
	 */
	@Test
	public final void testMakePurchase() {
		vendingMachine.addItem(item1, "A");
		vendingMachine.insertMoney(2.00);
		assertTrue("Was not able to make purchase with existent item and sufficient balance", vendingMachine.makePurchase("A"));
	}

	/**
	 * Test to see if a slot with no item can have something purchased.
	 */
	@Test
	public final void testMakePurchaseWithUnassignedSlot() {
		assertFalse("Could purchase item fro unassigned slot", vendingMachine.makePurchase("A"));
	}
	
	/**
	 * Test to see if an item cannot be purchased with an incorrect code.
	 */
	@Test (expected = VendingMachineException.class)
	public final void testMakePurchaseWrongCode() {
		vendingMachine.addItem(item1, "A");
		vendingMachine.makePurchase("E");
	}
	
	/**
	 * Test to see if a purchase can be made from an unassigned slot but a "sufficient" balance.
	 */
	@Test
	public final void testMakePurchaseNoItem() {
		vendingMachine.insertMoney(2.00);
		assertFalse("Was able to purchase item from unassigned slot.", vendingMachine.makePurchase("A"));
	}
	
	/**
	 * Test to see if a purchase can be made with an item in a slot but no balance.
	 */
	@Test
	public final void testMakePurchaseWithInsufficientBalance() {
		vendingMachine.addItem(item1, "A");
		assertFalse("Could purchase item with insufficient balance.", vendingMachine.makePurchase("A"));
	}
	
	/**
	 * Test to see if items can be successfully purchased twice.
	 */
	@Test
	public final void testMakePurchaseTwoItems() {
		vendingMachine.addItem(item1, "A");
		vendingMachine.addItem(item2, "B");
		vendingMachine.insertMoney(3.00);
		vendingMachine.makePurchase("A");
		assertTrue("Was unable to purchase subsequent item with enough money", vendingMachine.makePurchase("B"));
	}

	/**
	 * Test to see if an item can be purchased again after it was already purchased.
	 */
	@Test
	public final void testMakePurchaseSameItem() {
		vendingMachine.addItem(item1, "A");
		vendingMachine.insertMoney(3.00);
		vendingMachine.makePurchase("A");
		assertFalse("Could purchase item even though it was already purchased.", vendingMachine.makePurchase("A"));
	}
	
	/**
	 * Test to see if balance is correct after making a purchase.
	 */
	@Test
	public final void testProperBalanceAfterMakePurchase() {
		vendingMachine.addItem(item1, "A");
		vendingMachine.insertMoney(2.00);
		double initialBalance = vendingMachine.getBalance();
		vendingMachine.makePurchase("A");
		assertEquals("Got incorrect balance after purchase", initialBalance - 1.50, vendingMachine.getBalance(), 0.01);
	}

	/**
	 * Test returnChange() to see if proper amount of change is returned.
	 */
	@Test
	public final void testReturnChange() {
		vendingMachine.addItem(item1, "A");
		vendingMachine.insertMoney(2.00);
		vendingMachine.makePurchase("A");
		assertEquals("Got incorrect amount of change.", 0.50, vendingMachine.returnChange(), 0.01);
	}
	
	/**
	 * Test to see if change if balance is 0 after returning change.
	 */
	@Test
	public final void testBalanceAfterReturnChange() {
		vendingMachine.addItem(item1, "A");
		vendingMachine.insertMoney(2.00);
		vendingMachine.makePurchase("A");
		vendingMachine.returnChange();
		assertEquals("Vending machine still has balance.", 0.00, vendingMachine.getBalance(), 0.01);
	}
	
	/**
	 * Test to see if correct amount of change is returned after adding and using money several times
	 */
	@Test
	public final void testReturnChangeAfterPurchaseInsertCycle() {
		vendingMachine.addItem(item1, "A");
		vendingMachine.addItem(item2, "B");
		vendingMachine.insertMoney(2.00); //2.00
		vendingMachine.makePurchase("A"); //0.50
		vendingMachine.insertMoney(5.00); //5.50
		vendingMachine.makePurchase("B"); //4.00
		assertEquals("Got incorrect amount of change.", 4.00, vendingMachine.returnChange(), 0.01);
	}

	/**
	 * Test to see if correct amount of change is returned through purchasing and returning change several times.
	 */
	@Test
	public final void testReturnChangeAfterPurchaseReturnCycle() {
		vendingMachine.addItem(item1, "A");
		vendingMachine.addItem(item2, "B");
		vendingMachine.insertMoney(2.00); //2.00
		vendingMachine.makePurchase("A"); //0.50
		vendingMachine.returnChange(); //0.00
		vendingMachine.insertMoney(2.50); //2.50
		vendingMachine.makePurchase("B"); //1.00
		assertEquals("Got incorrect amount of change.", 1.00, vendingMachine.returnChange(), 0.01);
	}
	
	/**
	 * Test to see if a purchase can be made after returning change.
	 */
	@Test
	public final void testMakePurchaseAfterReturnChange() {
		vendingMachine.addItem(item1, "A");
		vendingMachine.addItem(item2, "B");
		vendingMachine.insertMoney(2.00); //2.00
		vendingMachine.makePurchase("A"); //0.50
		vendingMachine.returnChange(); //0.00
		assertFalse("Could make purchase after getting change.", vendingMachine.makePurchase("B"));
	}
}
