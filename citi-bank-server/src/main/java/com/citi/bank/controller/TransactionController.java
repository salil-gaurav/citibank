package com.citi.bank.controller;

import com.citi.bank.domain.Transaction;
import com.citi.bank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/app/data/transaction")
public class TransactionController extends BaseController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity transact(@RequestBody @Valid Transaction transaction, @ModelAttribute("customerKey") String key) {
        try {
            transactionService.transact(transaction, key);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTransaction(@RequestParam("accountId") String accountId) {
        return new ResponseEntity(transactionService.listTransactionByAccount(accountId), HttpStatus.OK);
    }

}
