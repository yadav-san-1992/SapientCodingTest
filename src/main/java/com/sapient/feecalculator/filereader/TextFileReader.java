package com.sapient.feecalculator.filereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.sapient.feecalculator.model.TransactionData;

public class TextFileReader extends AbstractFileReader {

	public void readFile(File fileName) {
		BufferedReader br = null;
		String line = "";
		String SplitBy = "\\|";

		try {

			br = new BufferedReader(new FileReader(fileName));
			while ((line = br.readLine()) != null) {
				String[] transactionAttributes = line.split(SplitBy);
				TransactionData transaction = setTransactionAttributes(transactionAttributes);
				saveTransaction(transaction);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
