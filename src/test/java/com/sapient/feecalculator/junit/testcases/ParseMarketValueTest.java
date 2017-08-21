package com.sapient.feecalculator.junit.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sapient.feecalculator.utility.Utility;

public class ParseMarketValueTest {

	@Test
	public void parseMarketValueTest()
	{
		Double parsedValue=Utility.parseMarketValue("101.9");
		assertEquals(new Double(101.9), parsedValue);
	}
}
