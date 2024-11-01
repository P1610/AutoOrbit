package com.project.carventure.transaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDao extends JpaRepository<Transaction, Integer> {

}
