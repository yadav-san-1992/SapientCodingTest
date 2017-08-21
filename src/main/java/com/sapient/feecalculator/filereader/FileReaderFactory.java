package com.sapient.feecalculator.filereader;

import com.sapient.feecalculator.constants.FeeCalcualtorConstants;

public class FileReaderFactory {

	public static AbstractFileReader getFileReader(String fileType) {

		switch (fileType) {
		case FeeCalcualtorConstants.FILE_TYPE_CSV:
			return new CsvFileReader();
		case FeeCalcualtorConstants.FILE_TYPE_TXT:
			return new TextFileReader();
		case FeeCalcualtorConstants.FILE_TYPE_EXCEL:
			return new ExcelFileReader();

		default:
			return null;
		}

	}
}
