package com.sapient.feecalculator.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sapient.feecalculator.constants.FeeCalcualtorConstants.TRANSACTION_TYPE;

public class Utility {

	public static Date parseDate(String date) {
		try{
			DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
			Date date1 = (Date)formatter.parse(date);
			return date1;
		}catch(Exception  ex){
			return null;
		}
	}
	
	public static Integer parseTransactionType(String type) {
		if(type.equals("BUY")){
			return TRANSACTION_TYPE.BUY.getType();
		}if(type.equals("SELL")){
			return TRANSACTION_TYPE.SELL.getType();
		}if(type.equals("DEPOSIT")){
			return TRANSACTION_TYPE.DEPOSIT.getType();
		}if(type.equals("WITHDRAW")){
			return TRANSACTION_TYPE.WITHDRAW.getType();
		}
		return null;}

	public static String getTypeName(Integer transactionType) {
		if(transactionType==TRANSACTION_TYPE.BUY.getType()){
			return TRANSACTION_TYPE.BUY.getName()+"\t";
		} else if(transactionType==TRANSACTION_TYPE.SELL.getType()){
			return TRANSACTION_TYPE.SELL.getName()+"\t";
		} else if(transactionType==TRANSACTION_TYPE.DEPOSIT.getType()){
			return TRANSACTION_TYPE.DEPOSIT.getName();
		} else if(transactionType==TRANSACTION_TYPE.WITHDRAW.getType()){
			return TRANSACTION_TYPE.WITHDRAW.getName();
		}
		return null;
	}
	
	public static Double parseMarketValue(String marketValue) {
		try{
			return Double.parseDouble(marketValue);
		}catch(Exception ex){
			return (double) 0;
		}
	}

	public static Boolean getPriority(String priority) {
		if(priority!= null){
			priority = priority.trim();
			if(priority.equalsIgnoreCase("Y")){
				return true;
			} else {
				return false;
			}
		}else{
			return false;
		}
	}

}
