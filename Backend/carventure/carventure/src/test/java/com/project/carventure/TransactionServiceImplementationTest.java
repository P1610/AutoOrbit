package com.project.carventure;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.carventure.transaction.Transaction;
import com.project.carventure.transaction.TransactionDao;
import com.project.carventure.transaction.TransactionException;
import com.project.carventure.transaction.TransactionServiceImplementation;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceImplementationTest {

    @Mock
    private TransactionDao transactionDao;

    @InjectMocks
    private TransactionServiceImplementation transactionService;

    private Collection<Transaction> transactions;

    @BeforeEach
    void setUp() {
        transactions = new ArrayList<>();
        Transaction transaction1 = new Transaction();
        Transaction transaction2 = new Transaction();
        transactions.add(transaction1);
        transactions.add(transaction2);
    }

    @Test
    void testViewSoldCars_TransactionsNotEmpty() {
        when(transactionDao.findAll()).thenReturn((List<Transaction>) transactions);

        Collection<Transaction> result = transactionService.viewSoldCars();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void testViewSoldCars_TransactionsEmpty() {
        when(transactionDao.findAll()).thenReturn(Collections.emptyList());

        TransactionException exception = assertThrows(TransactionException.class, () -> {
            transactionService.viewSoldCars();
        });

        assertEquals("transactions are null", exception.getMessage());
    }
}

