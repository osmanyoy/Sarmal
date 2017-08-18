package com.training.security.securitytraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Component
public class CustomUserDetails implements UserDetailsService {

    public static class UserInfo {
        public String username;
        public String password;
        public String role;
    }

    private Map<String, UserInfo> userInfoMap = new HashMap<>();

    @Autowired
    public CustomUserDetails(BCryptPasswordEncoder bCryptPasswordEncoder) {
        Stream.of("osman,yay,ADMIN",
                  "nil,yay,USER")
              .map(m -> m.split(","))
              .forEach(fr -> {
                  UserInfo userInfo = new UserInfo();
                  userInfo.username = fr[0];
                  userInfo.password =  bCryptPasswordEncoder.encode(fr[1]);
                  userInfo.role = fr[2];
                  userInfoMap.put(userInfo.username,userInfo);
              });
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws
                                                           UsernameNotFoundException {
        UserInfo userInfo = userInfoMap.get(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("User yok");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userInfo.role);
        grantedAuthorities.add(simpleGrantedAuthority);
        User user = new User(userInfo.username,
                             userInfo.password,
                             grantedAuthorities);
        return user;
    }

}
