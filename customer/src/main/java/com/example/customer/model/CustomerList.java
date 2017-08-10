package com.example.customer.model;

import com.example.customer.model.Customer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerList {

    @XmlElement(name = "customer")
    private List<Customer> customers;

    public CustomerList(){

    }

    public CustomerList(List<Customer> cutomers) {
        this.customers = cutomers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
