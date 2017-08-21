package com.sapient.feecalculator.junit.testcases;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import com.sapient.feecalculator.utility.Utility;

public class ParseDateTest {

	
	@SuppressWarnings("deprecation")
	@Test
	public void parseDateTest(){
        Date convertedDate= Utility.parseDate("Mon Aug 21 00:00:00 IST 2017");
        assertTrue("Comparing parse date ",convertedDate.getDate()==21&&convertedDate.getMonth()==7
        		&&convertedDate.getYear()==117);
 
    }
}
