package com.citi.bank.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class Transaction implements Serializable {

    private static final long serialVersionUID = 3931115099175748969L;

    @Id
    @Column
    private String transactionId;

    @Column
    private String transactionTime;

    @Column
    private String senderAccountId;

    @Column
    private String sender;

    @Column
    private String receiverAccountId;

    @Column
    private String receiver;

    @Column
    private String remarks;

    @Column
    private BigDecimal transactionAmount;

    @Column
    private Date time;
}