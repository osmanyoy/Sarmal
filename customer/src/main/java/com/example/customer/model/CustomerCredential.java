package com.example.customer.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class CustomerCredential {

    @Id
    @GeneratedValue
    private long ccid;
    @Column(unique = true)
    private String username;
    private String password;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    private List<Role> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getCcid() {
        return ccid;
    }

    public void setCcid(long ccid) {
        this.ccid = ccid;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
