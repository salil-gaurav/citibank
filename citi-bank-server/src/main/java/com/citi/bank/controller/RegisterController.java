package com.citi.bank.controller;

import com.citi.bank.domain.RegistrationDetails;
import com.citi.bank.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public ResponseEntity resgister(@Valid @RequestBody RegistrationDetails registrationDetails) {
        try {
            registrationService.register(registrationDetails);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
