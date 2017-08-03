package com.example.demo.security;

import com.example.demo.integration.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyCustomUserDetals implements UserDetailsService {

    @Autowired
    private MyPersonRepository myPersonRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = myPersonRepository.findByUsername(username)
                                          .orElseThrow(() -> new UsernameNotFoundException("Yok"));

        return new User(person.getUsername(), person.getPassword(),
                        AuthorityUtils.createAuthorityList(person.getRole()));
    }

}
