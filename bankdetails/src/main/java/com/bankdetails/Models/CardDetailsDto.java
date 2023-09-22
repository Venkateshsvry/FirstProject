package com.bankdetails.Models;

public class CardDetailsDto {
	private CardDetails cardDetails;
	private Double productPrice;
	

	public CardDetailsDto() {

	}


	public CardDetailsDto(CardDetails cardDetails, Double productPrice) {
		super();
		this.cardDetails = cardDetails;
		this.productPrice = productPrice;
	}


	public CardDetails getCardDetails() {
		return cardDetails;
	}


	public void setCardDetails(CardDetails cardDetails) {
		this.cardDetails = cardDetails;
	}


	public Double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}


	@Override
	public String toString() {
		return "CardDetailsDto [cardDetails=" + cardDetails + ", productPrice=" + productPrice + "]";
	}

	

	

	
}
