package com.example.customer.config;

import com.example.customer.manager.CustomerManager;
import com.example.customer.model.CustomerCredential;
import com.example.customer.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerDetailInfo implements UserDetailsService {

    @Autowired
    private CustomerManager customerManager;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        CustomerCredential customerCredential = customerManager.loadUserByUsernameWithUsername(s);
        List<Role> roles = customerCredential.getRoles();
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (Role role:roles
             ) {
            SimpleGrantedAuthority aut = new SimpleGrantedAuthority(role.getRole());
            simpleGrantedAuthorities.add(aut);
        }
        User user = new User(customerCredential.getUsername(), customerCredential.getPassword(),
                             simpleGrantedAuthorities);
        return user;
    }
}
