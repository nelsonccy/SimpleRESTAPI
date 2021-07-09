package com.bankapp.json;

import java.util.List;

import com.bankapp.model.Account;
import com.bankapp.model.Transaction;

public class EnquireAccountResponse {

	Account account;
	List<Transaction> transactions;
	String responseCode;
	
	
	public EnquireAccountResponse(Account account, List<Transaction> transactions, String responseCode) {
		super();
		this.account = account;
		this.transactions = transactions;
		this.responseCode = responseCode;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	
	
	
}
