package com.training.spring.customer;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@TableGenerator(name = "MyTableGen", table = "ID_TABLE", allocationSize = 1000, initialValue = 1, pkColumnName = "INDEX", valueColumnName = "VALUE", pkColumnValue = "ColoumVal")
    private long         id;
    private String       accountName;
    private double       balance;
    private EAccountType accountType;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public Account setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public long getId() {
        return id;
    }

    public Account setId(long id) {
        this.id = id;
        return this;
    }

    public String getAccountName() {
        return accountName;
    }

    public Account setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public double getBalance() {
        return balance;
    }

    public Account setBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public EAccountType getAccountType() {
        return accountType;
    }

    public Account setAccountType(EAccountType accountType) {
        this.accountType = accountType;
        return this;
    }
}
