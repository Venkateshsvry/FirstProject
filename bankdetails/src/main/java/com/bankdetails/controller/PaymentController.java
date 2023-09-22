package com.bankdetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankdetails.Models.CardDetailsDto;
import com.bankdetails.service.CardService;

@RestController
@RequestMapping("/card")
public class PaymentController {
	@Autowired
	CardService cardservice;

	@PostMapping("/add")
	public ResponseEntity<String> addbank(@RequestBody CardDetailsDto bankdetails) {
		try {
		String b = cardservice.add(bankdetails);
		
		return new ResponseEntity<>(b, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>("unable to proccess the request", HttpStatus.BAD_REQUEST);
		}
	}

//	@GetMapping("/viewByCardNumber/{id}")
//	public ResponseEntity<CardDetails> detailsByCardnumber(Long id) {
//		CardDetails b = cardservice.getById(id);
//		return new ResponseEntity<>(b, HttpStatus.OK);
//	}

	
}
