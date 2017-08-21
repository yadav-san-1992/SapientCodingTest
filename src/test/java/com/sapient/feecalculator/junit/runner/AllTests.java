package com.sapient.feecalculator.junit.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sapient.feecalculator.junit.testcases.CalculateTransationFeeTest;
import com.sapient.feecalculator.junit.testcases.FileExistsTest;
import com.sapient.feecalculator.junit.testcases.ParseDateTest;
import com.sapient.feecalculator.junit.testcases.ParseMarketValueTest;
import com.sapient.feecalculator.junit.testcases.ParseTransactionTypeTest;

@RunWith(Suite.class)
@SuiteClasses({ ParseDateTest.class,ParseMarketValueTest.class,ParseTransactionTypeTest.class,FileExistsTest.class,CalculateTransationFeeTest.class})

public class AllTests {

}
