package com.training.security.securitytraining;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @RequestMapping("/test/str")
    public String test() {
        return "test";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

}
