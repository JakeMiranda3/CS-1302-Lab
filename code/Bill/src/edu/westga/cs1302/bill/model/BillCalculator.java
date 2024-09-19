package edu.westga.cs1302.bill.model;

public class BillCalculator {
	
	/**
	 * Return the subtotal for the bill
	 * 
	 * @return the subtotal for the bill
	 */
	public static double getSubTotal(Bill bill) {
		double subTotal = 0.0;
		BillItem[] items = bill.getItems();
		for (BillItem item : items) {
			if (item != null) {
				subTotal += item.getAmount();
			}
		}
		return subTotal;
	}
	
	/**
	 * Return the tax for the bill
	 * 
	 * @return the tax for the bill
	 */
	public static double getTax(Bill bill) {
		return getSubTotal(bill) * 0.1;
	}
	
	/**
	 * Return the tip for the bill
	 * 
	 * @return the tip for the bill
	 */
	public double getTip(Bill bill) {
		return getSubTotal(bill) * 0.2;
	}
	
	/**
	 * Return the total for the bill
	 * 
	 * @return the total for the bill
	 */
	public double getTotal(Bill bill) {
		return getSubTotal(bill) + getTax(bill) + getTip(bill);
	}

}
