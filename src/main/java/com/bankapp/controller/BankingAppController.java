package com.bankapp.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.json.EnquireCustomerRequest;
import com.bankapp.json.EnquireCustomerResponse;
import com.bankapp.json.SendMoneyRequest;
import com.bankapp.json.SendMoneyResponse;
import com.bankapp.model.Account;
import com.bankapp.model.Transaction;
import com.bankapp.service.BankingAppImpl;

@RestController
public class BankingAppController {
	
	@Autowired
	private BankingAppImpl bankingAppImpl; 
	
	@GetMapping("/enquireGet/{id}")
	@ResponseBody
	public EnquireCustomerResponse enquireCustomerDetails(@PathVariable long id){
		
		Account cus=bankingAppImpl.enquireCustomer(id);
		
		List<Transaction> transactions = bankingAppImpl.getListofTransaction(id);
		return new EnquireCustomerResponse(cus,transactions);
		
	}
	
	@GetMapping("/enquire")
	@ResponseBody
	public EnquireCustomerResponse enquireCustomerDetails(@RequestBody EnquireCustomerRequest request){
		
		Long id = request.getCustomerId();
		
		Account cus=bankingAppImpl.enquireCustomer(id);
		List<Transaction> transactions = bankingAppImpl.getListofTransaction(id);
		return new EnquireCustomerResponse(cus,transactions);
		
	}
	
	
	@PostMapping("/sendMoney")
	@ResponseBody
	public SendMoneyResponse sendMoney(@RequestBody SendMoneyRequest json) {
		Long senderId = json.getSenderId();
		Long receiverId = json.getReceiverId();
		BigDecimal amount = json.getAmount();
		
		 
		 
		 SendMoneyResponse response =  new SendMoneyResponse();
		 response.setSenderId(senderId);
		 response.setReceiverId(receiverId);
		 response.setAmount(amount);
		 if(bankingAppImpl.sendMoney(senderId, receiverId, amount))
			 response.setResponseCode("0000");
		 else response.setResponseCode("9999");
		 
		 return response;
	}
	
	
	
	
}
