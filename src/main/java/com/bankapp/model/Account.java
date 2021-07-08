package com.bankapp.model;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="ACCOUNT")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private BigDecimal balance; 
	
	
	
	@OneToMany(mappedBy="senderId", fetch = FetchType.LAZY)
	private Collection<Transaction> sender;
	
	@OneToMany(mappedBy="receiverId" , fetch = FetchType.LAZY)
	private Collection<Transaction> receiver;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}  
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
