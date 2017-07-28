package com.training.spring;

import com.training.spring.customer.*;
import com.training.spring.data.CustomerCustomRepository;
import com.training.spring.data.CustomerRepository;
import edu.ytu.TestObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.*;

// @SpringBootApplication(scanBasePackages = {"edu.ytu","com.training.spring"})
@SpringBootApplication
@EnableAsync
@Configuration
@EnableWebSecurity
public class SiemensbasicApplication implements ApplicationRunner {

    private static Logger logger = LoggerFactory.getLogger(SiemensbasicApplication.class);

    @Autowired
    @ImplV1
    private IMyInterface myInterface;

    private Person   personFromConstruct;
    private Employee employee;

    @Autowired
    private TestObj testObj;

    @Autowired
    public SiemensbasicApplication(@Qualifier("kisi") Person per,
                                   Employee employee) {
        personFromConstruct = per;
        // Yanlış --> System.out.println("Person : " + person.getName());
        this.employee = employee;
    }

    @Autowired
    private Person kisi;

    @Autowired
    @Qualifier("kisiYarat")
    private Person person2;

    @Bean("myExecuter")
    public Executor executor() {
        return Executors.newFixedThreadPool(10);
    }

    private Person person3;

    public Person getPerson() {
        return kisi;
    }

    @Autowired
    @Qualifier("kisi")
    public void personKoy(Person per) {
        person3 = per;
    }

    @Autowired
    public void setPerson(Person kisi) {
        kisi.setPhone("455353453");
        kisi.setName("Default");
        this.kisi = kisi;
    }

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerCustomRepository customerCustomRepository;


    public Person getPerson2() {
        return person2;
    }

    public void setPerson2(Person person2) {
        this.person2 = person2;
    }

    @PostConstruct
    public void basla() {
        kisi.setName("osman");
        kisi.setPhone("834387328");
        System.out.println("Person : " + kisi);
    }

    @PreDestroy
    public void olmedenIOnce() {
        System.out.println("Person : " + kisi + " ölüyor");
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SiemensbasicApplication.class,
                                                                       args);
        // SiemensbasicApplication siemensbasicApplication = new SiemensbasicApplication();
        SiemensbasicApplication siemensbasicApplication = context.getBean(SiemensbasicApplication.class);

    }

    @Bean
    public AsyncTest asyncTestCreator(){
        return new AsyncTest();
    }

    @Autowired
    private AsyncTest asyncTest;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        final Customer customer = new Customer();
        customer.setName("osman");
        customer.setSurname("yay");
        customer.setAge(47);

        customer.setPassword("osman12");
        customer.setUsername("osman");

        Adress adress = new Adress();
        adress.setCity("Adana");
        adress.setPostalcode(100101);
        adress.setStreetName("Atatürk");
        adress.setTown("Ceyhan");

        customer.setAdress(adress);

        PersonalData personalData = new PersonalData();

        personalData.setIdentityNumber("" + UUID.randomUUID());
        personalData.setSpouseName("Ayşe");

        customer.setPersonalData(personalData);
        // personalData.setCustomer(customer);

        if (logger.isDebugEnabled()) {
            logger.debug("Persisting customer : " + customer + " date : " + System.currentTimeMillis());
        }

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account().setAccountName("osmanA")
                                  .setAccountType(EAccountType.TL)
                                  .setBalance(100)
                                  .setCustomer(customer));
        accounts.add(new Account().setAccountName("osmanB")
                                  .setAccountType(EAccountType.DOLAR)
                                  .setBalance(100)
                                  .setCustomer(customer));
        accounts.add(new Account().setAccountName("osmanC")
                                  .setAccountType(EAccountType.EURO)
                                  .setBalance(100)
                                  .setCustomer(customer));

        customer.setAccounts(accounts);

        // customerCustomRepository.save2(customer);

        // customerRepository.save(customer);

        // customer.setAge(57);
        customerRepository.save(customer);

        // System.out.println(customer.getPassword());

        List<Customer> customerList = customerRepository.testMyQuery(47,
                                                                     "osman");
        System.out.println(customerList);

        Future<List<Customer>> future = customerRepository.findByName("osman");
        System.out.println("future test");
        // n lines
        if (future.isDone()) {
            List<Customer> customers = future.get();
        }
        // n lines
        List<Customer> customers = future.get();
        List<Customer> customers2 = future.get(10000,
                                               TimeUnit.MILLISECONDS);
        int a = 100;
        ListenableFuture<List<Customer>> listenableFuture = customerRepository.findAllByName("osman");
        listenableFuture.addCallback(new ListenableFutureCallback<List<Customer>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("INT A : " + a);
            }

            @Override
            public void onSuccess(List<Customer> result) {
                System.out.println("Result : " + result + " Thread Name : " + Thread.currentThread()
                                                                                    .getName());
            }
        });
        System.out.println("Main Thread : " + Thread.currentThread()
                                                    .getName());
        Future<String> stringFuture = asyncTest.testAsync();
        String sf = stringFuture.get();
        System.out.println(sf);
    }

//    @Autowired
//    public void generalAuthention(AuthenticationManagerBuilder managerBuilder) throws Exception {
//        managerBuilder.inMemoryAuthentication()
//                      .withUser("osman")
//                      .password("pass")
//                      .roles("ADMIN",
//                             "USER");
//
//        managerBuilder.inMemoryAuthentication()
//                      .withUser("ayse")
//                      .password("pass12")
//                      .roles("USER");
//    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailProvider();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public void generalAuthention(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

}
