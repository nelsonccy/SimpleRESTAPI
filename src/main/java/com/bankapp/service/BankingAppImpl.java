package com.bankapp.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.dao.AccountRepository;
import com.bankapp.dao.TransactionRepository;
import com.bankapp.model.Account;
import com.bankapp.model.Transaction;

@Repository
public class BankingAppImpl {
	
	@Autowired
	private AccountRepository accountDAO;
	@Autowired
	private TransactionRepository transactionDAO;
	
	public Account enquireCustomer(Long id) {
		
		Optional<Account> account = accountDAO.findById(id);
		if(account.isPresent()) {
			return account.get();
		}
		return null;
		
		
	}
	
	
	public List<Transaction> getListofTransaction(Long customerId){
	
		
		return transactionDAO.listAllTransaction(customerId);
	}
		
	public boolean sendMoney(Long senderId , Long receiverId, BigDecimal amount) {
		///add exception case checking
		
		
		Account sender = this.accountDAO.findById(senderId).get();
		Account receiver = this.accountDAO.findById(receiverId).get();
		BigDecimal senderOrgBalance = sender.getBalance();
		BigDecimal receiverOrgBalance = receiver.getBalance();
		
		BigDecimal senderAfterBalance = senderOrgBalance.subtract(amount);
		BigDecimal receiverAfterBalance = receiverOrgBalance.add(amount);
		
		if(senderAfterBalance.compareTo(new BigDecimal("0"))== -1) {
			return false;
		}
		
		
		
		
		sender.setBalance(senderAfterBalance);
		receiver.setBalance(receiverAfterBalance);
		
		
		
		
		
		Transaction transaction = new Transaction();
		transaction.setSenderId(sender);
		transaction.setReceiverId(receiver);
		transaction.setAmount(amount);
		Date currentDate = new Date();
		transaction.setCreatedTimeStamp(new Timestamp(currentDate.getTime()));
		
		this.transactionDAO.save(transaction);
		this.transactionDAO.flush();
		
		this.accountDAO.save(sender);
		this.accountDAO.save(receiver);
		this.accountDAO.flush();
		
		return true;
		
		
		
		
	}
	
	

}
