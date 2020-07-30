package com.citi.bank.service;

import com.citi.bank.domain.Transaction;

import java.util.List;

public interface TransactionService {

    void transact(Transaction transaction, String userKey) throws Exception;

    List<Transaction> listTransactionByAccount(String accountId);
}
