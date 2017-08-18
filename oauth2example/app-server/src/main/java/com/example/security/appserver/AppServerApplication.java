package com.example.security.appserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableOAuth2Client
@RestController
public class AppServerApplication {

    @Autowired
    private OAuth2RestTemplate auth2RestTemplate;

    @Bean
    public OAuth2RestTemplate auth2RestTemplate(OAuth2ProtectedResourceDetails details,
                                                @Qualifier("oauth2ClientContext") OAuth2ClientContext context) {
        OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(details,
                                                                       context);
        return oAuth2RestTemplate;
    }

    @RequestMapping("/promotion")
    public String promot() {
        Person person = auth2RestTemplate.getForObject("http://127.0.0.1:9000/perInfo",
                                                       Person.class);

        if (person.getAge() > 25) {
            return "promotion platinium paket";
        } else {
            return "promotion genç Turkcell";
        }

    }

    @RequestMapping("/promotion2")
    public String promot2() {
        String person = auth2RestTemplate.getForObject("http://127.0.0.1:9001/merInfo",
                                                       String.class);

        return person;
    }


    public static void main(String[] args) {
        SpringApplication.run(AppServerApplication.class,
                              args);
    }
}
