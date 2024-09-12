package edu.westga.cs1302.bill.view;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillItem;

/** Generates text to summarize a Bill
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class BillTextifier {

	/** Return a String summarizing the bill.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return a String summarizing the bill
	 */
	public String getText(Bill bill) {
		if (bill == null) {
			throw new IllegalArgumentException("Must provide a valid Bill");
		}
		String text = "ITEMS" + System.lineSeparator();
		for (BillItem item : bill.getItems()) {
			text += item.getName() + " - " + item.getAmount() + System.lineSeparator();
		}
		
		text += System.lineSeparator();
		text += "SUBTOTAL - $" + bill.getSubTotal() + System.lineSeparator();
		text += "TAX - $" + bill.getTax() + System.lineSeparator();
		text += "TIP - $" + bill.getTip() + System.lineSeparator();
		text += "TOTAL - $" + bill.getTotal();
		
		return text;
	}
	
}
