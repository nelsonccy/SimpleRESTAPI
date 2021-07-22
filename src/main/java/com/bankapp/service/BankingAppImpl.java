package com.bankapp.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bankapp.dao.AccountRepository;
import com.bankapp.dao.TransactionRepository;
import com.bankapp.model.Account;
import com.bankapp.model.Transaction;

@Component
public class BankingAppImpl {
	
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TransactionRepository transactionRepository;
	
	
	public Account create(String name , BigDecimal balance) {
		
		Account account = new Account();
		account.setName(name);
		account.setBalance(balance);
		accountRepository.save(account);
		return account;
		
	}
	
	public List<Account> listAccount() {
		return accountRepository.findAll();
	}
	
	public Account enquireCustomer(Long id) {
		
		Optional<Account> account = accountRepository.findById(id);
		if(account.isPresent()) {
			return account.get();
		}
		return null;
		
		
	}
	
	
	public List<Transaction> getListofTransaction(Long customerId){
	
		
		return transactionRepository.listAllTransaction(customerId);
	}
		
	public synchronized boolean sendMoney(Long senderId , Long receiverId, BigDecimal amount) {
		///add exception case checking
		
		
		Account sender = enquireCustomer(senderId);
		Account receiver = enquireCustomer(receiverId);
		if(sender==null || receiver==null) {
			return false;
		}
		BigDecimal senderOrgBalance = sender.getBalance()==null?new BigDecimal(0):sender.getBalance();
		BigDecimal receiverOrgBalance = receiver.getBalance()==null?new BigDecimal(0):receiver.getBalance();;
		
		
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
		
		this.transactionRepository.save(transaction);
		this.transactionRepository.flush();
		
		this.accountRepository.save(sender);
		this.accountRepository.save(receiver);
		this.accountRepository.flush();
		
		return true;
		
		
		
		
	}
	
	

}
