package com.training.spring.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class UserDetailProvider implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private CustomerManager customerManager;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Customer customerByUserName = customerManager.getCustomerByUserName(s);
        if (customerByUserName == null) {
            throw new UsernameNotFoundException("User yok");
        }
        User user = new User(s,
                             passwordEncoder.encode(customerByUserName.getPassword()),
                             true,
                             true,
                             true,
                             true,
                             AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
        return user;
    }


}
