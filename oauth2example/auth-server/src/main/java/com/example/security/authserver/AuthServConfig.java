package com.example.security.authserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AuthServConfig extends AuthorizationServerConfigurerAdapter {

    @Value("${security.oauth2.jwt.privateKey}")
    private String jwtPrivateKey;

    @Value("${security.oauth2.jwt.publicKey}")
    private String jwtPublicKey;

    @Bean
    public JwtAccessTokenConverter tokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(jwtPrivateKey);
        converter.setVerifierKey(jwtPublicKey);
        return converter;
    }

    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(tokenConverter());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("isAnonymous() || hasRole('ROLE_TRUSTED_CLIENT') || permitAll()")
                   .checkTokenAccess("hasRole('TRUSTED_CLIENT')");
    }

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                 .tokenStore(tokenStore())
                 .accessTokenConverter(tokenConverter());
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws
                                                                  Exception {
        clients.inMemory()
               .withClient("client1")
               .secret("secret1")
               .scopes("createContact",
                       "personalInfo")
               .autoApprove(false)
               .authorizedGrantTypes("authorization_code",
                                     "client_credential",
                                     "refresh_token");
    }


}
