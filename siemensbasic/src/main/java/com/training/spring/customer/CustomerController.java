package com.training.spring.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@RestController
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CustomerController {

    @Autowired
    private CustomerManager customerManager;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/h")
    public String hello(Principal principal){
        return "hello";
    }

    @RequestMapping(path = "/customer/{id}", produces = {"application/json",
                                                         "application/xml"})
    public Customer getCustomer(@PathVariable("id") long id,
                                HttpServletRequest servletRequest,
                                HttpServletResponse servletResponse,
                                Principal principal) {
        System.out.println("Principal : " + principal);
        return customerManager.getCustomerById(id);
    }

    @RequestMapping(path = "/allcustomers", produces = {"application/json",
                                                        "application/xml"})
    public Customers getAllCustomers(@RequestParam("count") int count) {
        Customers customers = new Customers();
        customers.setCustomers(customerManager.getAllCustomer());
        return customers;

    }

    @RequestMapping(method = RequestMethod.PUT, path = "/createCustomer", produces = {"application/json",
                                                                                      "application/xml"}, consumes = {"application/json",
                                                                                                                      "application/xml"})
    public ResponseEntity<Boolean> createCustomer(@RequestBody Customer customer) {
        if (customer == null) {
            return new ResponseEntity<Boolean>(false,
                                               HttpStatus.BAD_REQUEST);
        }
        if (customer.getAge() > 120) {
            return new ResponseEntity<Boolean>(false,
                                               HttpStatus.BAD_REQUEST);
        }
        customerManager.createCustomer(customer);
        return new ResponseEntity<Boolean>(true,
                                           HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/createCustomer2", produces = {"application/json",
                                                                                       "application/xml"}, consumes = {"application/json",
                                                                                                                       "application/xml"})
    public ResponseEntity<Object> createCustomer2(@RequestBody Customer customer) {
        if (customer == null) {
            return new ResponseEntity<Object>(new Error(100,
                                                        "customer boş geldi"),
                                              HttpStatus.BAD_REQUEST);
        }
        if (customer.getAge() > 120) {
            return new ResponseEntity<Object>(new Error(101,
                                                        "age 120 den büyük geldi"),
                                              HttpStatus.BAD_REQUEST);
        }
        try {
            customerManager.createCustomer(customer);

        }
        catch (Exception ex) {
            return new ResponseEntity<Object>(new Error(101,
                                                        "Problem oldu daha sonra deneyiniz"),
                                              HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(true,
                                          HttpStatus.OK);
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handleException(Exception ex) {
        return new Error(100,
                         ex.getMessage());
    }

    public static class Error {
        private int    code;
        private String desc;

        public Error(int code,
                     String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

}
