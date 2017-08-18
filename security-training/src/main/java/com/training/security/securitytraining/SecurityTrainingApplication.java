package com.training.security.securitytraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityTrainingApplication {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void initSecurity(AuthenticationManagerBuilder authenticationManagerBuilder,
                             CustomUserDetails customUserDetails) throws
                                                                  Exception {
        authenticationManagerBuilder.userDetailsService(customUserDetails).passwordEncoder(passwordEncoder());
    }

    //    @Autowired
    //    public void initSecurity(AuthenticationManagerBuilder authenticationManagerBuilder) throws
    //                                                                                        Exception {
    //        authenticationManagerBuilder.inMemoryAuthentication()
    //                                    .withUser("osman")
    //                                    .password("osman12")
    //                                    .roles("USER",
    //                                           "ADMIN")
    //                                    .and()
    //                                    .withUser("nil")
    //                                    .password("nil12")
    //                                    .roles("USER",
    //                                           "ADMIN")
    //
    //        ;
    //    }

    public static void main(String[] args) {
        SpringApplication.run(SecurityTrainingApplication.class,
                              args);
    }
}
