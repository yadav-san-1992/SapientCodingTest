package com.sapient.feecalculator.junit.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sapient.feecalculator.utility.Utility;

public class ParseTransactionTypeTest {

	@Test
	public void parseTransactionTypeTest()
	{
		Integer  actualParsedValue=Utility.parseTransactionType("BUY");
		assertEquals(new Integer(1), actualParsedValue);
	}
}
