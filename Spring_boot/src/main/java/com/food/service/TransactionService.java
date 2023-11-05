package com.food.service;

import java.util.List;

import com.food.models.Transaction;
import com.food.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	public List<Transaction> getAllTransaction(){
		return transactionRepository.findAll();
	}

	public Transaction createTransaction(Transaction transaction){
		return transactionRepository.save(transaction);
	}

}
