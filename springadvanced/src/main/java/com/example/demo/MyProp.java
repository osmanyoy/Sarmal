package com.example.demo;

import javax.validation.constraints.Pattern;

/**
 * Created by Osman on 31.07.2017.
 */
public class MyProp {

    private String name;

    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
