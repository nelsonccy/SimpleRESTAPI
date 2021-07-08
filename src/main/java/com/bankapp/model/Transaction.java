package com.bankapp.model;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="senderId")
	private Account senderId;
	 
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="receiverId")
	private Account receiverId;
	
	private BigDecimal amount;
	private Timestamp createdTimeStamp;
	
	public Transaction() {}
	
	public Account getSenderId() {
		return senderId;
	}
	public void setSenderId(Account senderId) {
		this.senderId = senderId;
	} 
	public Account getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(Account receiverId) {
		this.receiverId = receiverId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public Timestamp getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

}
