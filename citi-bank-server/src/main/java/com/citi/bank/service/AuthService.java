package com.citi.bank.service;

import com.citi.bank.entity.Auth;
import com.citi.bank.repository.AuthRepository;
import com.citi.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        final com.citi.bank.entity.User user = userRepository.findById(email).orElseThrow(() -> new UsernameNotFoundException("NOT_FOUND"));
        final Auth authUser = authRepository.findById(user.getKey()).orElseThrow(() -> new UsernameNotFoundException("NOT_FOUND"));
        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_ALLOW"));
        return new User(authUser.getId(), authUser.getPassword(), roles);
    }
}
