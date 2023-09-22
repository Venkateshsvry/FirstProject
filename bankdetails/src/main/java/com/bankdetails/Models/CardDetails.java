package com.bankdetails.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bankDetails")
public class CardDetails {
	@Id
	private Long cardNumber;
	private String cardHolderName;
	private Double balance;
	private int cvv;
	public CardDetails() {
	
	}
	public CardDetails(Long cardNumber, String cardHolderName, Double balance, int cvv) {
		super();
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.balance = balance;
		this.cvv = cvv;
	}
	public Long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	@Override
	public String toString() {
		return "CardDetails [cardNumber=" + cardNumber + ", cardHolderName=" + cardHolderName + ", balance=" + balance
				+ ", cvv=" + cvv + "]";
	}
	

}
