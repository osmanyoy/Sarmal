package com.training.security.appserver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRest {

    private final OAuth2RestTemplate restTemplate;

    @Autowired
    public AppRest(OAuth2RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/customer")
    public String getCustomer() {
        return restTemplate.getForObject("http://localhost:9000/customer", String.class);
    }

}
