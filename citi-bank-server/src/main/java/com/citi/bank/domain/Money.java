package com.citi.bank.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

@Data
public class Money implements Serializable {

    private BigDecimal amount = BigDecimal.ZERO;
    private Currency currency = Currency.getInstance("USD");
}
