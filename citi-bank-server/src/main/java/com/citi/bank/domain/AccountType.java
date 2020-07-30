package com.citi.bank.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum AccountType {

    SAVING ("SAVING"),
    CURRENT ("CURRENT"),
    MONEY_MARKET ("MONEY_MARKET");

    @Getter private String accountType;
}
