package com.citi.bank.controller;

import com.citi.bank.domain.Account;
import com.citi.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/app/data/account")
public class AccounController extends BaseController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/list")
    public ResponseEntity getAccounts(@ModelAttribute("customerKey") String key) {
        return new ResponseEntity(accountService.getAccounts(key), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAccount(@RequestParam("accountId") String accountId, @ModelAttribute("customerKey") String key) {
        return new ResponseEntity(accountService.getAccount(accountId, key), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addAccount(@ModelAttribute("customerKey") String key, @Valid @RequestBody Account account) {
        accountService.add(account, key);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity deleteAccount(@RequestParam("accountId") String accountId) {
        accountService.delete(accountId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
