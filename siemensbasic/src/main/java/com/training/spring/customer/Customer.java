package com.training.spring.customer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Base64;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Customer.testMyQuery",query = "select c from Customer c where c.age=?1 and c.name=?2")
})
@Table(name = "CUSTOMER_TABLE",indexes = {@Index(name = "soyisim_index",columnList = "surname")})
@SecondaryTable(name = "CUSTOMER_PASSWORD")
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "CUSTOMER_ID")
    private long id;

    @NotNull
    @Size(max = 30, min = 2)
    @Column(name = "CUSTOMER_NAME", length = 30, nullable = false)
    private String name;
    private String surname;
    private int    age;

    @Column(table = "CUSTOMER_PASSWORD")
    private String username;

    @Column(table = "CUSTOMER_PASSWORD")
    private String password;

    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "city", column = @Column(name = "SEHIR"))})
    private Adress adress;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "personaldata_id")
    private PersonalData personalData;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL},mappedBy = "customer")
    private List<Account> accounts;


    public Customer(long id,
                    String name,
                    String surname,
                    int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Customer() {
    }

    @PreUpdate
    @PrePersist
    public void beforeInsertAndUpdate() {
        if (password == null) {
            return;
        }

        byte[] encode = Base64.getEncoder()
                              .encode(password.getBytes());
        password = new String(encode);
    }

    @PostPersist
    @PostUpdate
    @PostLoad
    public void afterInsertAndUpdate() {
        if (password == null) {
            return;
        }
        byte[] decode = Base64.getDecoder()
                              .decode(password.getBytes());
        password = new String(decode);

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

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

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}

