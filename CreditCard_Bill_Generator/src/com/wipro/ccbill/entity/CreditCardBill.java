package com.wipro.ccbill.entity;


import java.util.Date;


import com.wipro.ccbill.exception.InputValidationException;

public class CreditCardBill{
	
	private String creditCardNo;
	private String customerId;
	private Date billDate;
	private Transaction monthTransactions[];
	
	public CreditCardBill ()
	{
		
	}
	public CreditCardBill (String creditCardNo, String customerId, Date BillDate, Transaction monthTransactions[])
	{
		this.creditCardNo=creditCardNo;
		this.customerId=customerId;
		this.billDate=BillDate;
		this.monthTransactions=monthTransactions;
		
	}
	
	
	public double getTotalAmount(String transactionType)
	{  
		double transactionAmount = 0.0;
		if(transactionType!="DB"&&transactionType!="CR")
		{
			return 0.0;
		}
		
		else
		{
		for(int i=0;i<monthTransactions.length;i++)
		{  
			if(monthTransactions[i].getTransactionType().equals(transactionType))
			{
			transactionAmount+=monthTransactions[i].getTransactionAmount();
			}
		}
		
		return transactionAmount;
		}
		
		
	}
	public double calculateBillAmount() 
	{
		if(validateData()=="valid")
		{
			if(monthTransactions!=null&&monthTransactions.length>0)
			{
				double db;
				double cr;
				double tp,interest,result;
				db=getTotalAmount("DB");
				cr=getTotalAmount("CR");
		        tp=db-cr;
				interest=(tp*0.199/12);
				result=tp+interest;
				return result;
	        }
		}
		return 0.0;
	}
	public String validateData()  
	{
		try{
		if(creditCardNo!=null&&creditCardNo.length()==16&&customerId!=null&&customerId.length()==6)
		{
			return "valid";
		}
		else
		{
			throw new InputValidationException("Invalid data");
		}
		}
		catch(InputValidationException ive)
		{
			return null;	
		}
		
	}
	
	
}
