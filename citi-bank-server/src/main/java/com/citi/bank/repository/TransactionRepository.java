package com.citi.bank.repository;

import com.citi.bank.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    @Query("Select ob from com.citi.bank.entity.Transaction ob where ob.senderAccountId = ?1 OR ob.receiverAccountId = ?1")
    List<Transaction> findTransactionByAccount(String accountId);
}
