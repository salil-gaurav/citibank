package com.citi.bank.service;

import com.citi.bank.domain.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAccounts(String key);

    Account getAccount(String accountId, String key);

    String add(Account account, String userKey);

    void delete(String accountId);
}
