package com.bankapp.json;

import java.util.List;

import com.bankapp.model.Account;
import com.bankapp.model.Transaction;

public class EnquireCustomerResponse {

	Account customer;
	List<Transaction> transactions;
	
	
	
	public EnquireCustomerResponse(Account customer, List<Transaction> transactions) {
		super();
		this.customer = customer;
		this.transactions = transactions;
	}
	public Account getCustomer() {
		return customer;
	}
	public void setCustomer(Account customer) {
		this.customer = customer;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
	
}
