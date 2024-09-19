package edu.westga.cs1302.bill.test.model.bill_calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

class TestGetSubtotal {

	@Test
	public void test() {
		Bill tab = new Bill();
		BillItem item1 = new BillItem("orange", 5);
		tab.addItem(item1);
		assertEquals(5,BillCalculator.getSubTotal(tab));
	}

}
