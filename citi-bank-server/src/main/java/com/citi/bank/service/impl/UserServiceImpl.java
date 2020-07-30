package com.citi.bank.service.impl;

import com.citi.bank.domain.UserDetails;
import com.citi.bank.entity.User;
import com.citi.bank.repository.UserRepository;
import com.citi.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void updateUser(String id, String field, String value) {

    }

    @Override
    public UserDetails getUser(String key) {
        final User user = userRepository.findByKey(key);
        final UserDetails userDetails = new UserDetails();
        userDetails.setAddress(user.getAddress());
        userDetails.setFirstName(user.getFirstName());
        userDetails.setLastName(user.getLastName());
        userDetails.setAddress(user.getAddress());
        userDetails.setPhoneNumber(user.getPhoneNumber());
        userDetails.setId(user.getKey());
        return userDetails;
    }
}
