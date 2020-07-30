package com.citi.bank.service.impl;

import com.citi.bank.domain.RegistrationDetails;
import com.citi.bank.entity.Auth;
import com.citi.bank.entity.User;
import com.citi.bank.repository.AuthRepository;
import com.citi.bank.repository.UserRepository;
import com.citi.bank.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class RegistartionServiceImpl implements RegistrationService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void register(RegistrationDetails registrationDetails) throws Exception {
       Optional<User> userOptional =  userRepository.findById(registrationDetails.getUser().getEmail());
       if(userOptional.isPresent()) {
           throw new Exception("USER_ALREADY_REGISTERED");
       } else {
           final User user = new User();
           user.setUser(registrationDetails.getUser());
           final String UUID = java.util.UUID.randomUUID().toString();
           user.setKey(UUID);
           final Auth auth = new Auth(UUID, registrationDetails.getPassword());
           userRepository.save(user);
           authRepository.save(auth);
       }
    }
}
