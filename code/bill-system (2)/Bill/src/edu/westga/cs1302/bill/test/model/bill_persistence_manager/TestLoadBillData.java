package edu.westga.cs1302.bill.test.model.bill_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillPersistenceManager;

class TestLoadBillData {

	@Test
	void testEmptyFile() throws IOException {
		try (FileWriter writer = new FileWriter(BillPersistenceManager.DATA_FILE)) {
			writer.write("");
		}
		Bill bill = BillPersistenceManager.loadBillData();
		assertEquals(0, bill.getSize());
	}

	@Test
	void testOneBillItemInFile() throws IOException {
		try (FileWriter writer = new FileWriter(BillPersistenceManager.DATA_FILE)) {
			writer.write("No Server Set" + System.lineSeparator());
			writer.write("steak,25.0" + System.lineSeparator());
		}
		Bill bill = BillPersistenceManager.loadBillData();
		assertEquals("No Server Set", bill.getServerName(), "checking the first line (should be server)");
		assertEquals(1, bill.getItems().length, "checking the number of bill items loaded");
		assertEquals("steak", bill.getItems()[0].getName(), "checking the name of the first bill item");
		assertEquals(25.0, bill.getItems()[0].getAmount(), "checking the amount of the first bill item");
	}

	@Test
	void testMultipleBillItemsInFile() throws IOException {
		try (FileWriter writer = new FileWriter(BillPersistenceManager.DATA_FILE)) {
			writer.write("No Server Set" + System.lineSeparator());
			writer.write("steak,25.0" + System.lineSeparator());
			writer.write("coke,3.0" + System.lineSeparator());
		}
		Bill bill = BillPersistenceManager.loadBillData();
		assertEquals("No Server Set", bill.getServerName(), "checking the first line (should be server)");
		assertEquals(2, bill.getItems().length, "checking the number of bill items loaded");
		assertEquals("steak", bill.getItems()[0].getName(), "checking the name of the first bill item");
		assertEquals(25.0, bill.getItems()[0].getAmount(), "checking the amount of the first bill item");
		assertEquals("coke", bill.getItems()[1].getName(), "checking the name of the second bill item");
		assertEquals(3.0, bill.getItems()[1].getAmount(), "checking the amount of the second bill item");
	}

	@Test
	void testOneBillItemInFileWithInvalidAmount() throws IOException {
		try (FileWriter writer = new FileWriter(BillPersistenceManager.DATA_FILE)) {
			writer.write("No Server Set" + System.lineSeparator());
			writer.write("steak,0.0" + System.lineSeparator());
		}
		assertThrows(IOException.class, () -> {
			BillPersistenceManager.loadBillData();
		});
	}

	@Test
	void testOneBillItemInFileWithInvalidName() throws IOException {
		try (FileWriter writer = new FileWriter(BillPersistenceManager.DATA_FILE)) {
			writer.write("No Server Set" + System.lineSeparator());
			writer.write(",0.4" + System.lineSeparator());
		}
		assertThrows(IOException.class, () -> {
			BillPersistenceManager.loadBillData();
		});
	}

}
