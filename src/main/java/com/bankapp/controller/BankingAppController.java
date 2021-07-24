package com.bankapp.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.json.EnquireAccountRequest;
import com.bankapp.json.EnquireAccountResponse;
import com.bankapp.json.SendMoneyRequest;
import com.bankapp.json.SendMoneyResponse;
import com.bankapp.model.Account;
import com.bankapp.model.Transaction;
import com.bankapp.service.BankingAppImpl;

@RestController
public class BankingAppController {
	
	@Autowired
	private BankingAppImpl bankingAppImpl; 
		
	
	@GetMapping("hello")
	@ResponseBody String hello() {
		return "Hello World!!!!!!!!!!! test";
		
	}
	
	//add a create cus
	@PostMapping("/create")
	@ResponseBody
	public Account create(@RequestParam String name ,@RequestParam BigDecimal balance) {

		return bankingAppImpl.create(name, balance);
		
	}
	
	@GetMapping("/enquire/{id}")
	@ResponseBody
	public EnquireAccountResponse getCustomerDetails(@PathVariable Long id){
		
		
		
		Account cus=bankingAppImpl.enquireCustomer(id);
		List<Transaction> transactions = bankingAppImpl.getListofTransaction(id);
		
		String responseCode = "999";
		if(cus!=null) {
			responseCode = "000";
		}
		return new EnquireAccountResponse(cus,transactions,responseCode);
		
	}
	
	@GetMapping("/getAll")
	@ResponseBody
	public List<Account> getAllAccount(){
		
		return bankingAppImpl.listAccount();
		
	}
	
	@GetMapping("/get")
	@ResponseBody
	public EnquireAccountResponse getCustomerDetails2(@RequestParam Long id){
		
		
		
		Account cus=bankingAppImpl.enquireCustomer(id);
		List<Transaction> transactions = bankingAppImpl.getListofTransaction(id);
		
		String responseCode = "999";
		if(cus!=null) {
			responseCode = "000";
		}
		return new EnquireAccountResponse(cus,transactions,responseCode);
		
	}
	
	@GetMapping("/enquire")
	@ResponseBody
	public EnquireAccountResponse enquireCustomerDetails(@RequestBody EnquireAccountRequest request){
		
		Long id = request.getAccountId();
		
		Account cus=bankingAppImpl.enquireCustomer(id);
		List<Transaction> transactions = bankingAppImpl.getListofTransaction(id);
		
		String responseCode = "999";
		if(cus!=null) {
			responseCode = "000";
		}
		return new EnquireAccountResponse(cus,transactions,responseCode);
		
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
			 response.setResponseCode("000");
		 else response.setResponseCode("999");
		 
		 return response;
	}
	
	
	
	
}
