package com.project.carventure.transaction;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/soldcars")
	public Collection<TransactionDto> viewSoldCars() {
		Collection<Transaction> transactions = this.transactionService.viewSoldCars();
		// Map Transaction entities to TransactionDto
		Collection<TransactionDto> transactionDtos = transactions.stream().map(transaction -> {
			TransactionDto dto = new TransactionDto();
			dto.setId(transaction.getId());
			dto.setAmount(transaction.getAmount());
			dto.setDiscount_percentage(transaction.getDiscount_percentage());
			dto.setTransaction_date(transaction.getTransaction_date());
			dto.setUser(transaction.getUser());
			dto.setAsking_price(transaction.getAsking_price());
			dto.setCar(transaction.getCar());
			return dto;
		}).collect(Collectors.toList());

		return transactionDtos;
	}

}
