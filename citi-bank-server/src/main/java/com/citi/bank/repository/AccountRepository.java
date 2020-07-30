package com.citi.bank.repository;

import com.citi.bank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    @Query("Select ob from com.citi.bank.entity.Account ob where ob.userKey = ?1")
    List<Account> findByUserKey(String userKey);

    @Query("Select ob from com.citi.bank.entity.Account ob where ob.userKey = ?1 AND ob.accountId = ?2")
    Account findByUserKeyAndAccountId(String userKey, String accountId);
}
