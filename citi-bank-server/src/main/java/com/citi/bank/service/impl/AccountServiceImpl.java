package com.citi.bank.service.impl;

import com.citi.bank.domain.Account;
import com.citi.bank.domain.Money;
import com.citi.bank.repository.AccountRepository;
import com.citi.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAccounts(String key) {
        final List<Account> accounts = new ArrayList<>();
        accountRepository.findByUserKey(key).forEach(account -> {
            final Account account1 = new Account();
            account1.setAccountId(account.getAccountId());
            account1.setAccountType(account.getAccountType());
            final Money money = new Money();
            money.setAmount(account.getAmount());
            money.setCurrency(Currency.getInstance(account.getCurrency()));
            account1.setCurrentMoney(money);
            account1.setAccountName(account.getAccountName());
            accounts.add(account1);
        });
        return accounts;
    }

    @Override
    public Account getAccount(String accountId, String key) {
        final com.citi.bank.entity.Account account = accountRepository.findByUserKeyAndAccountId(key,accountId);
        Account account1 = null;
        if(account != null) {
            account1 = new Account();
            account1.setAccountId(account.getAccountId());
            account1.setAccountType(account.getAccountType());
            final Money money = new Money();
            money.setAmount(account.getAmount());
            money.setCurrency(Currency.getInstance(account.getCurrency()));
            account1.setCurrentMoney(money);
            account1.setAccountName(account.getAccountName());
        }
        return account1;
    }

    @Override
    public String add(Account account, String userKey) {
        final com.citi.bank.entity.Account account1 = new com.citi.bank.entity.Account();
        account1.setAccountId(UUID.randomUUID().toString());
        account1.setAccountType(account.getAccountType());
        account1.setUserKey(userKey);
        account1.setAmount(account.getCurrentMoney().getAmount());
        account1.setCurrency(account.getCurrentMoney().getCurrency().toString());
        account1.setAccountName(account.getAccountName());
        accountRepository.save(account1);
        return account1.getAccountId();
    }

    @Override
    public void delete(String accountId) {
        accountRepository.deleteById(accountId);
    }
}
