package com.sapient.feecalculator.filereader;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sapient.feecalculator.constants.FeeCalcualtorConstants.TRANSACTION_FEE;
import com.sapient.feecalculator.constants.FeeCalcualtorConstants.TRANSACTION_TYPE;
import com.sapient.feecalculator.model.TransactionData;
import com.sapient.feecalculator.utility.Utility;

public abstract class AbstractFileReader {

	public List<TransactionData> transactionDataList;

	public abstract void readFile(File fileName);

	 
	
	//Method to save the transaction into list.
	public List<TransactionData> saveTransaction(TransactionData transaction) {

		if (transactionDataList == null) {
			transactionDataList = new ArrayList<TransactionData>();
		}

		 transactionDataList.add(calculateTransactionFee(transaction));
		 
		 return transactionDataList;

	}

	// Method to update the fee according to transaction.
	public TransactionData calculateTransactionFee(TransactionData transaction) {
		if (isIntradayTransaction(transaction)) {
			transaction.setTransactionFees(TRANSACTION_FEE.TEN.getFees());
		} else {

			if (transaction.getPriority()) {
				transaction.setTransactionFees(TRANSACTION_FEE.FIVE_HUNDREAD.getFees());

			} else {
				if (transaction.getTransactionType() == TRANSACTION_TYPE.SELL.getType()
						|| transaction.getTransactionType() == TRANSACTION_TYPE.WITHDRAW.getType()) {

					transaction.setTransactionFees(TRANSACTION_FEE.HUNDREAD.getFees());

				} else if (transaction.getTransactionType() == TRANSACTION_TYPE.BUY.getType()
						|| transaction.getTransactionType() == TRANSACTION_TYPE.DEPOSIT.getType()) {

					transaction.setTransactionFees(TRANSACTION_FEE.FIFTY.getFees());
				}

			}

		}
		return transaction;
	}

	// Method to check that transaction is Intra Day or not
	public boolean isIntradayTransaction(TransactionData transaction) {
		boolean isIntraDayTransaction = false;
		TransactionData temp = null;
		if (transactionDataList.size() > 0) {
			for (TransactionData trans : transactionDataList) {
				if (trans.getClientId().equals(transaction.getClientId())
						&& trans.getSecurityId().equals(transaction.getSecurityId())
						&& trans.getTransactionDate().equals(transaction.getTransactionDate())) {
					if ((trans.getTransactionType() == TRANSACTION_TYPE.BUY.getType()
							&& transaction.getTransactionType() == TRANSACTION_TYPE.SELL.getType())
							|| (trans.getTransactionType() == TRANSACTION_TYPE.SELL.getType()
									&& transaction.getTransactionType() == TRANSACTION_TYPE.BUY.getType())) {
						isIntraDayTransaction = true;
						temp = trans;
						break;
					}
				}

			}

			if (temp != null) {
				transactionDataList.remove(temp);
				temp.setTransactionFees(TRANSACTION_FEE.TEN.getFees());
				transactionDataList.add(temp);
			}

		} else {
			isIntraDayTransaction = false;
		}

		return isIntraDayTransaction;
	}

	
	public TransactionData setTransactionAttributes(String[] transactionAttributes) {
		/*for (String string : transactionAttributes) {
			System.out.print(" " + string);
		}*/
		TransactionData transaction = new TransactionData();
		transaction.setExternalTransactionID(transactionAttributes[0]);
		transaction.setClientId(transactionAttributes[1]);
		transaction.setSecurityId(transactionAttributes[2]);
		transaction.setTransactionType(Utility.parseTransactionType(transactionAttributes[3]));
		transaction.setTransactionDate(Utility.parseDate(transactionAttributes[4]));
		transaction.setMarketValue(Utility.parseMarketValue(transactionAttributes[5]));
		transaction.setPriority(Utility.getPriority(transactionAttributes[6]));
	//	System.out.println();
		return transaction;
		
	}

	
	//This method will show the Summary of the Transaction Report.
	public void showTransactionReportSummuary() {
		Collections.sort(transactionDataList, new TransactionData());
		System.out.println("Transaction Summary Report:-");
		System.out.println();
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("Client Id | Transaction Type |    Transaction Date     | Priority   | Processing Fee    |");
		for (TransactionData transaction : transactionDataList) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println(transaction.getClientId() + "    \t| "
					+ Utility.getTypeName(transaction.getTransactionType()) + "\t| " + transaction.getTransactionDate()
					+ "\t| " + (transaction.getPriority() ? "HIGH\t" : "NORMAL") + "\t| "
					+ transaction.getTransactionFees() + "\t|");
		}
		System.out.println("----------------------------------------------------------------------------------------");
	}
}
