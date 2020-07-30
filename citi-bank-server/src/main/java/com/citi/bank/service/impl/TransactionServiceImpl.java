package com.citi.bank.service.impl;

import com.citi.bank.domain.Transaction;
import com.citi.bank.entity.Account;
import com.citi.bank.repository.AccountRepository;
import com.citi.bank.repository.TransactionRepository;
import com.citi.bank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void transact(Transaction transaction, String userKey) throws Exception {
        final Account senderAccount = accountRepository.findByUserKeyAndAccountId(userKey, transaction.getSenderAccountId());
        final Account receiverAccount = accountRepository.findById(transaction.getReceiverAccountId()).get();
        if( senderAccount == null) {
            throw new Exception("SENDER_ACCOUNT_NOT_FOUND");
        } else if( receiverAccount == null) {
            throw new Exception("RECEIVER_ACCOUNT_NOT_FOUND");
        } if(senderAccount.getAccountId().equals(receiverAccount.getAccountId())) {
            throw new Exception("SAME_ACCOUNT");
        } else {
            final BigDecimal currentBalance = senderAccount.getAmount();
            final BigDecimal fundToBeTransferred = transaction.getAmount();
            if(currentBalance.compareTo(fundToBeTransferred) != -1) {
                final com.citi.bank.entity.Transaction transaction1 = new com.citi.bank.entity.Transaction();
                transaction1.setTransactionId(UUID.randomUUID().toString());
                transaction1.setReceiver(transaction.getReceiver());
                transaction1.setReceiverAccountId(transaction.getReceiverAccountId());
                transaction1.setSender(transaction.getSender());
                transaction1.setSenderAccountId(transaction.getSenderAccountId());
                transaction1.setRemarks(transaction.getRemarks());
                transaction1.setTransactionAmount(transaction.getAmount());
                transaction1.setTime(new Date());


                senderAccount.setAmount(senderAccount.getAmount().subtract(fundToBeTransferred));
                receiverAccount.setAmount(receiverAccount.getAmount().add(fundToBeTransferred));
                transactionRepository.save(transaction1);
                accountRepository.save(senderAccount);
                accountRepository.save(receiverAccount);
            } else {
                throw new Exception("LESS_FUND");
            }
        }
    }

    @Override
    public List<Transaction> listTransactionByAccount(String accountId) {
        final List<Transaction> list = new ArrayList<>();
        final List<com.citi.bank.entity.Transaction> transactions = transactionRepository.findTransactionByAccount(accountId);
        transactions.forEach(transaction -> {
            final Transaction transaction1 = new Transaction();
            transaction1.setAmount(transaction.getTransactionAmount());
            transaction1.setRemarks(transaction.getRemarks());
            transaction1.setReceiver(transaction.getReceiver());
            transaction1.setReceiverAccountId(transaction.getReceiverAccountId());
            transaction1.setSender(transaction.getSender());
            transaction1.setSenderAccountId(transaction.getSenderAccountId());
            transaction1.setTime(transaction.getTime());
            transaction1.setTransactionId(transaction.getTransactionId());
            list.add(transaction1);
        });

        return list;
    }
}
