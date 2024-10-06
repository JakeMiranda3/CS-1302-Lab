package edu.westga.cs1302.bill.test.model.bill_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillItem;
import edu.westga.cs1302.bill.model.BillPersistenceManager;

class TestSaveBillData {

	@Test
	void testNullBill() {
		assertThrows(IllegalArgumentException.class, () -> {
			BillPersistenceManager.saveBillData(null);
		});
	}

	@Test
	void testNoItemsInBill() throws IOException {
		Bill bill = new Bill();
		BillPersistenceManager.saveBillData(bill);
		File inputFile = new File(BillPersistenceManager.DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertEquals("No Server Set", reader.nextLine(), "check the first line");
			assertFalse(reader.hasNextLine(), "checking that file is empty");
		}
	}

	@Test
	void testServerNameInBill() throws IOException {
		Bill bill = new Bill();
		BillItem item1 = new BillItem("Steak", 25);
		bill.addItem(item1);
		bill.setServerName("Jake");
		BillPersistenceManager.saveBillData(bill);
		File inputFile = new File(BillPersistenceManager.DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertEquals("Jake", reader.nextLine(), "check the first line");
			assertEquals("Steak,25.0", reader.nextLine(), "check the second line");
			assertFalse(reader.hasNextLine(), "checking that file is empty");
		}

	}

	@Test
	void testOneItemInBill() throws IOException {
		Bill bill = new Bill();
		BillItem item1 = new BillItem("Steak", 25);
		bill.addItem(item1);
		BillPersistenceManager.saveBillData(bill);
		File inputFile = new File(BillPersistenceManager.DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertEquals("No Server Set", reader.nextLine(), "check the first line");
			assertEquals("Steak,25.0", reader.nextLine(), "check the second line");
			assertFalse(reader.hasNextLine(), "checking that file is empty");
		}

	}

	@Test
	void testMultipleItemsInBill() throws IOException {
		Bill bill = new Bill();
		BillItem item1 = new BillItem("Steak", 25);
		bill.addItem(item1);
		BillItem item2 = new BillItem("Fries", 5);
		bill.addItem(item2);
		BillPersistenceManager.saveBillData(bill);
		File inputFile = new File(BillPersistenceManager.DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertEquals("No Server Set", reader.nextLine(), "check the first line");
			assertEquals("Steak,25.0", reader.nextLine(), "check the second line");
			assertEquals("Fries,5.0", reader.nextLine(), "check the third line");
			assertFalse(reader.hasNextLine(), "checking that file is empty");
		}

	}

}
