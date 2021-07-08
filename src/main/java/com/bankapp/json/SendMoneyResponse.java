package com.bankapp.json;

import java.math.BigDecimal;


public class SendMoneyResponse {

	private Long senderId;
	private Long receiverId;
	private BigDecimal amount;
	private String responseCode;
	
	public SendMoneyResponse() {};
	
	public SendMoneyResponse(Long senderId, Long receiverId, BigDecimal amount) {
		super();
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.amount = amount;
	}
	public Long getSenderId() {
		return senderId;
	}
	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}
	public Long getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	
	
}
