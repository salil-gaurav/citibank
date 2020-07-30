package com.citi.bank.entity;

import com.citi.bank.domain.AccountType;
import com.citi.bank.domain.Money;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
public class Account implements Serializable {

    private static final long serialVersionUID = 3911125099175748969L;
    @Column
    private String userKey;
    @Column
    private AccountType accountType;
    @Column
    @Id
    private String accountId;
    @Column
    private BigDecimal amount;
    @Column
    private String currency;
    @Column
    private String accountName;
}