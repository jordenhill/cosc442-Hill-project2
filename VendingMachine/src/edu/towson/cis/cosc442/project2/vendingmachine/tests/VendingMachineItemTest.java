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
		vendingMachineItem = new VendingMachineItem("Coca-cola", 1.50);
		assertNotNull("Successfully constructed vending machine item", vendingMachineItem);
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem#getName()}.
	 */
	@Test
	public final void testGetName() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem#getPrice()}.
	 */
	@Test
	public final void testGetPrice() {
		fail("Not yet implemented"); // TODO
	}

}
