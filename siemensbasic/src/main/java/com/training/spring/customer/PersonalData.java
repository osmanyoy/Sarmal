package com.training.spring.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class PersonalData {

    @Id
    private String identityNumber;
    private String spouseName;

    @JsonBackReference
    @JsonIgnore
    @XmlTransient
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "customer_id",foreignKey = @ForeignKey(name = "customer_id_key",value = ConstraintMode.NO_CONSTRAINT ))
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }
}
