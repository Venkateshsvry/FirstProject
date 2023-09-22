package com.bankdetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bankdetails.Models.CardDetails;
import com.bankdetails.Models.CardDetailsDto;
import com.bankdetails.repositories.BankRepository;

@Service
public class CardServiceImpl implements CardService {
	@Autowired
	BankRepository brep;

	@Override
	public String add(CardDetailsDto bankdetials) {
		try {
		 ResponseEntity<String> response=debit(bankdetials);
		if(response.getStatusCode()==HttpStatus.CONFLICT) {
			brep.save(bankdetials.getCardDetails());
			String s = debited(bankdetials);
			return s;
		}
		else if(response.getStatusCode()==HttpStatus.ACCEPTED) {
			return response.getBody();
		}
		else {
			throw new NullPointerException(response.getBody());
		}
		
		}catch (Exception e) {
		 throw new RuntimeException(e.getMessage()) ;
		}
	}

	public ResponseEntity<String> debit(CardDetailsDto bank) {
		try {
			CardDetails b = getById(bank.getCardDetails().getCardNumber());
			if(!b.toString().isBlank()) {
			String s = debited(bank);
			return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
			}
			else {
				return new ResponseEntity<>("", HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}

	}
	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public String update(CardDetails bankdetails) {
//		brep.save(bankdetails);
//		return "updated Successfully";
//	}

//	@Override
//	public List<BankDetails> viewAll() {
//		List<BankDetails> list = brep.findAll();
//		return list;
//	}

	@Override
	public String debited(CardDetailsDto bank) {
		CardDetails b=brep.findByAccountNumber(bank.getCardDetails().getCardNumber());
		Double a=b.getBalance();
		Double a1=bank.getProductPrice();
		if(a1<=a) {
		Double a2=a-a1;
		b.setBalance(a2);
		brep.save(b);
		
		return "debited amount of Rs"+a1 ;
		}
		else {
			throw new ArithmeticException("insufficient balance");
		}
	}

	
//	@Override
//	public String deletebyId(Long id) {
//		brep.deleteByAccountNumber(id);
//		return "deleted account successfully";
//	}

//	@Override
//	public String deposit(BankDetailsDto bank) {
//	BankDetails b=brep.findByAccountNumber(bank.getAccountNumber());
//	Double a=b.getBalance();
//	Double a1=bank.getAmount();
//	Double a2=a+a1;
//	b.setBalance(a2);
//	brep.save(b);
//		return "deposited succesfully"+a1;
//	}

	@Override
	public CardDetails getById(Long id) {
		CardDetails b= brep.findByAccountNumber(id);
		return b;
	}

}
