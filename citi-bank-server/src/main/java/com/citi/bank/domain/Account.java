package com.citi.bank.domain;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class Account implements Serializable {

    private static final long serialVersionUID = 3911125099175748969L;
    @Valid
    @NotNull(message = "AccountType is mandatory")
    private AccountType accountType;
    private String accountId;
    private Money currentMoney;
    @NotEmpty
    private String accountName;
}
