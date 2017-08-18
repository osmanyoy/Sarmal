package com.training.security.authserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
public class AuthConfig extends AuthorizationServerConfigurerAdapter {

//    @Autowired
//    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws
                                                                          Exception {
        super.configure(security);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws
                                                                  Exception {
        clients.inMemory()
               .withClient("client1")
               .secret("secret1")
               .autoApprove(false)
               .authorities("ZEN")
               .authorizedGrantTypes("authorization_code",
                                     "refresh_token",
                                     "password",
                                     "client_credentials")
               .scopes("test",
                       "read");
    }

//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws
//                                                                            Exception {
//        endpoints.authenticationManager(authenticationManager);
//    }
}
