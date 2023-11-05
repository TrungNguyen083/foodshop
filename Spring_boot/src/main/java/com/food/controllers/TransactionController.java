package com.food.controllers;

import java.util.List;

import com.food.models.Transaction;
import com.food.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TransactionController {
	@Autowired
	TransactionService transactionService;
	
	
	@PostMapping(value="/savetransection")
	public void saveTransaction(@RequestBody Transaction tns) {
		transactionService.createTransaction(tns);
	}
	
	@GetMapping(value="/tansections")
	public List<Transaction> allTransaction(){
		return transactionService.getAllTransaction();
	}
}
