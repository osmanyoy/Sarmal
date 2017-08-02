package com.training.spring.ws;

import com.sun.xml.internal.ws.api.server.HttpEndpoint;
import com.training.spring.customer.Customer;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import javax.xml.ws.RequestWrapper;

@WebService(targetNamespace = "http://osmanli.com")
public class NewWebservice {

    @WebMethod(operationName = "osmanliKahvesi")
    public String helloWorld(Customer customer){
        return "Hello world " + customer;
    }

    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1/test",new NewWebservice() );
    }
}
