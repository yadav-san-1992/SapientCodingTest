package com.sapient.feecalculator.runner;

import java.io.File;

import com.sapient.feecalculator.constants.FeeCalcualtorConstants;
import com.sapient.feecalculator.filereader.AbstractFileReader;
import com.sapient.feecalculator.filereader.FileReaderFactory;

public class ApplicationStarter {

	public static void main(String[] args) {
		
		
		// For Excel file
		File transactionExcelFile = new File("src/main/resources/sampleData.xlsx");
		AbstractFileReader excelFileReader = FileReaderFactory.getFileReader(FeeCalcualtorConstants.FILE_TYPE_EXCEL);
		excelFileReader.readFile(transactionExcelFile);
		excelFileReader.showTransactionReportSummuary();

		// For Txt file Data sepatrated with "|" 
		/*File transactionTxtFile = new File("src/main/resources/sampleData.txt");
		AbstractFileReader txtFileReader = FileReaderFactory.getFileReader(FeeCalcualtorConstants.FILE_TYPE_TXT);
		txtFileReader.readFile(transactionTxtFile);
		txtFileReader.showTransactionReportSummuary();*/
		
		// For CSv file Data separated with ","
		/*File transactionCsvFile = new File("src/main/resources/sampleData.csv");
		AbstractFileReader csvFileReader = FileReaderFactory.getFileReader(FeeCalcualtorConstants.FILE_TYPE_CSV);
		csvFileReader.readFile(transactionCsvFile);
		csvFileReader.showTransactionReportSummuary();*/
		
	}

}
