package com.sapient.feecalculator.junit.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sapient.feecalculator.filereader.ExcelFileReader;
import com.sapient.feecalculator.model.TransactionData;
import com.sapient.feecalculator.utility.Utility;

public class CalculateTransationFeeTest {

	@Test
	public void calculateTransationFeeTest()
	{
		TransactionData transaction = new TransactionData();
		transaction.setExternalTransactionID("SAPEXTXN1");
		transaction.setClientId("GS");
		transaction.setSecurityId("ICICI");
		transaction.setTransactionType(Utility.parseTransactionType("BUY"));
		transaction.setTransactionDate(Utility.parseDate("Sat Nov 23 00:00:00 IST 2013"));
		transaction.setMarketValue(Utility.parseMarketValue("101.90"));
		transaction.setPriority(Utility.getPriority("Y"));
		
		Double transactionfee=new ExcelFileReader().saveTransaction(transaction).get(0).getTransactionFees();
		
		assertEquals(new Double(500), transactionfee);
	}
}
