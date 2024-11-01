package com.project.carventure.transaction;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.carventure.user.User;
import com.project.carventure.user.UserDao;

@Service
public class TransactionServiceImplementation implements TransactionService {

	@Autowired
	private TransactionDao transactionDao;

	@Autowired
	private UserDao userDao;

	@Override
	public Collection<Transaction> viewSoldCars() {
		Collection<Transaction> transactions = this.transactionDao.findAll();
		if (transactions.isEmpty()) {
			throw new TransactionException("transactions are null");
		} else
			return transactions;

	}

}
