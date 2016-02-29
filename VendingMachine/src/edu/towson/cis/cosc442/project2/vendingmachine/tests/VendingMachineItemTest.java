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
 * @author jhill19
 *
 */
public class VendingMachineItemTest {
	
	VendingMachineItem vendingMachineItem;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test to see if VendingMachineItem is constructed as intended.
	 */
	@Test
	public final void testVendingMachineItem() {
		vendingMachineItem = new VendingMachineItem("Coca-cola", 1.50);
		assertNotNull("Unsuccessfully constructed vending machine item", vendingMachineItem);
	}


	/**
	 * Test to see if an item with a negative price cannot be created.
	 */
	@Test (expected = VendingMachineException.class)
	public final void testVendingMachineItemNegativePrice() {
		vendingMachineItem = new VendingMachineItem("Coca-cola", -1.50);
	}
	
	/**
	 * Test  to see if proper name is returned from item.
	 */
	@Test
	public final void testGetName() {
		vendingMachineItem = new VendingMachineItem("Coca-cola", 1.50);
		assertTrue("Returned incorrect item name.", "Coca-cola".equals(vendingMachineItem.getName()));
	}

	/**
	 * Test to see if proper price is returned from item.
	 */
	@Test
	public final void testGetPrice() {
		vendingMachineItem = new VendingMachineItem("Coca-cola", 1.50);
		assertEquals("Returned incorrect item price", 1.50, vendingMachineItem.getPrice(), 0.01);
	}

}
