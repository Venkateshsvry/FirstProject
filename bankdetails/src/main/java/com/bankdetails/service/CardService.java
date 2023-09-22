package com.bankdetails.service;

import org.springframework.stereotype.Service;


import com.bankdetails.Models.CardDetails;
import com.bankdetails.Models.CardDetailsDto;

@Service
public interface CardService {
	public String add(CardDetailsDto bankdetiails);

	//public String update(CardDetails bankdetails);

	//public List<BankDetails> viewAll();

	public CardDetails getById(Long id);

	//public String deletebyId(Long id);

	//public String deposit(BankDetailsDto bank);

	public String debited(CardDetailsDto bank);
}
