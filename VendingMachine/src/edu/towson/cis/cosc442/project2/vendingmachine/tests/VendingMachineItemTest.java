/**
 * 
 */
package edu.towson.cis.cosc442.project2.vendingmachine.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem;

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
		vendingMachineItem = new VendingMachineItem("Coca-cola", 1.50);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem#VendingMachineItem(java.lang.String, double)}.
	 */
	@Test
	public final void testVendingMachineItem() {
		assertNotNull("Unsuccessfully constructed vending machine item", vendingMachineItem);
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem#getName()}.
	 */
	@Test
	public final void testGetName() {
		assertTrue("Returned incorrect item name.", "Coca-cola".equals(vendingMachineItem.getName()));
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem#getPrice()}.
	 */
	@Test
	public final void testGetPrice() {
		assertEquals("Returned incorrect item price", 1.50, vendingMachineItem.getPrice(), 0.01);
	}

}
