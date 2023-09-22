package com.bankdetails.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bankdetails.Models.CardDetails;



@Repository
public interface BankRepository  extends MongoRepository<CardDetails, Integer>{

CardDetails findByAccountNumber(Long id);
String deleteByAccountNumber(Long id);


}
