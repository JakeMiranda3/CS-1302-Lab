package edu.westga.cs1302.bill.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Supports saving and loading bill data,
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class BillPersistenceManager {

	public static final String DATA_FILE = "data.txt";

	/**
	 * Save the bill!
	 * 
	 * Writes all bill data to DATA_FILE
	 * 
	 * @precondition bill != null
	 * @postcondition none
	 * 
	 * @param bill the bill to save
	 * @throws IOException
	 */
	public static void saveBillData(Bill bill) throws IOException {
		if (bill == null) {
			throw new IllegalArgumentException("Must provide a bill");
		}
		try (FileWriter writer = new FileWriter(DATA_FILE)) {
			writer.write(bill.getServerName() + System.lineSeparator());
			for (BillItem currItem : bill.getItems()) {
				writer.write(currItem.getName() + "," + currItem.getAmount() + System.lineSeparator());
			}
		}

	}

	/**
	 * Load the bill!
	 * 
	 * Reads from DATA_FILE File is assumed to use the same format as saveBillData
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the bill loaded
	 * @throws FileNotFoundException file at DATA_FILE location does not exist
	 * @throws IOException           invalid or missing name/amount found when
	 *                               trying to create a billItem
	 */
	public static Bill loadBillData() throws FileNotFoundException, IOException {
		Bill bill = new Bill();
		File inputFile = new File(DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			if (reader.hasNextLine()) {
				bill.setServerName(reader.nextLine());
				for (int lineNumber = 2; reader.hasNextLine(); lineNumber++) {
					String baseLine = reader.nextLine();
					String strippedLine = baseLine.strip();
					String[] parts = strippedLine.split(",");
					try {
						String name = parts[0];
						double amount = Double.parseDouble(parts[1]);
						BillItem nextItem = new BillItem(name, amount);
						bill.addItem(nextItem);
					} catch (NumberFormatException numError) {
						throw new IOException("Unable to read amount (was not a valid int) on line " + lineNumber
								+ " : " + strippedLine);

					} catch (IllegalArgumentException billItemDataError) {
						throw new IOException(
								"Unable to create billItem, bad name/amount " + lineNumber + " : " + strippedLine);
					} catch (IndexOutOfBoundsException billItemDataError) {
						throw new IOException(
								"Missing either name and/or amount on line " + lineNumber + " : " + strippedLine);
					}
				}
			}
		}
		return bill;
	}

}
