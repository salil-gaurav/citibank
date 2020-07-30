package com.citi.bank.service;


import com.citi.bank.domain.UserDetails;

public interface UserService {

    void updateUser(String key, String field, String value);

    UserDetails getUser(String key);
}
