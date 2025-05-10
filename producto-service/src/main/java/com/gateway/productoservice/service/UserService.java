package com.gateway.productoservice.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {


    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return (User) User.withUsername(username)
                .password("")
                .authorities("USER")
                .build();
    }

}