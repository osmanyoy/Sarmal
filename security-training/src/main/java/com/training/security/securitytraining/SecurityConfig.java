package com.training.security.securitytraining;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws
                                                Exception {
        http.addFilterAfter(new MyFilter(),
                            AnonymousAuthenticationFilter.class)
            .
                    authorizeRequests()
            .antMatchers("/test/**")
            .anonymous()
            .antMatchers("/manage/**")
            .hasRole("ADMIN")
            .antMatchers("/**")
            .authenticated()
            .and()
            .httpBasic();
    }
}
