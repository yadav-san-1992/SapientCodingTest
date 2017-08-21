package com.sapient.feecalculator.filereader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sapient.feecalculator.model.TransactionData;

public class ExcelFileReader extends AbstractFileReader {

	@Override
	public void readFile(File fileName) {
		try {

			FileInputStream excelFile = new FileInputStream(fileName);

			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean heading = true;
			StringBuilder sb=new StringBuilder();
			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				if (heading) {
					currentRow = iterator.next();
					heading = false;
				}
				Iterator<Cell> cellIterator = currentRow.iterator();
				boolean date = true;
				while (cellIterator.hasNext()) {

					Cell currentCell = cellIterator.next();
					if (currentCell.getCellTypeEnum() == CellType.STRING) {
						//System.out.print(currentCell.getStringCellValue() + "--");
						sb.append(currentCell.getStringCellValue());
						sb.append("--");
					} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
						if (date) {
							//System.out.print(currentCell.getDateCellValue() + "--");
							date = false;
							sb.append(currentCell.getDateCellValue());
							sb.append("--");
						} else {
							sb.append(currentCell.getNumericCellValue());
							sb.append("--");
							//System.out.print(currentCell.getNumericCellValue() + "--");
						}
					}

				}
				//System.out.println();
				//System.out.println(sb);
				String[] transactionAttributes=sb.toString().split("--");
				TransactionData transaction = setTransactionAttributes(transactionAttributes);
				saveTransaction(transaction);
				sb.delete(0, sb.length()-1);

			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
