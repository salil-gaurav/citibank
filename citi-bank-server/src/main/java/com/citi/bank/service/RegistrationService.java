package com.citi.bank.service;

import com.citi.bank.domain.RegistrationDetails;

public interface RegistrationService {

    void register(RegistrationDetails registrationDetails) throws Exception;
}
