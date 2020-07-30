package com.citi.bank.domain;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Transaction implements Serializable {

    private static final long serialVersionUID = 3931115099175748969L;

    private String transactionId;
    @NotEmpty(message = "Sender is mandatory")
    private String senderAccountId;
    private String sender;
    @NotEmpty(message = "Receiver is mandatory")
    private String receiverAccountId;
    private String receiver;
    private String remarks;
    @NotNull(message = "Amount is mandatory")
    private BigDecimal amount;
    private Date time;
}
