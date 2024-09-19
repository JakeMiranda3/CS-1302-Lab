package edu.westga.cs1302.bill.test.model.bill_calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

class TestGetSubtotal {

	@Test
	public void testSubTotalWhenTheresNoItemsInTheBill() {
		Bill tab = new Bill();
		assertEquals(0, BillCalculator.getSubTotal(tab.getItems()), "Checks the sub total of the bill");

	}

	@Test
	public void testSubTotalWhenTheresOneItemInTheBill() {
		Bill tab = new Bill();
		BillItem item1 = new BillItem("orange", 5);
		tab.addItem(item1);
		assertEquals("orange", item1.getName(), "Checks the name of the item");
		assertEquals(5, item1.getAmount(), "Checks the price of the item");
		assertEquals(5, BillCalculator.getSubTotal(tab.getItems()), "Checks the sub total of the bill");
	}

	@Test
	public void testSubTotalWhenTheresTwoItemInTheBill() {
		Bill tab = new Bill();
		BillItem item1 = new BillItem("orange", 5);
		BillItem item2 = new BillItem("coke", 3);
		tab.addItem(item1);
		tab.addItem(item2);
		assertEquals("orange", item1.getName(), "Checks the name of the item");
		assertEquals(5, item1.getAmount(), "Checks the price of the item");
		assertEquals("coke", item2.getName(), "Checks the name of the item");
		assertEquals(3, item2.getAmount(), "Checks the price of the item");
		assertEquals(8, BillCalculator.getSubTotal(tab.getItems()), "Checks the sub total of the bill");
	}

}
