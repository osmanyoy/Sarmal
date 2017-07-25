package com.training.spring.web;

import com.training.spring.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {

    @RequestMapping("/merhaba")
    public String hello() {
        return "hello osman naber?";
    }

    @RequestMapping(path = "/person", method = RequestMethod.POST, produces = {"application/json",
                                                                               "application/xml"})
    public Person person() {
        Person person = new Person();
        person.setName("osman");
        person.setPhone("0930923");
        return person;
    }

    @RequestMapping(path = "/p2/{name}/{telefon}/{age}", method = RequestMethod.POST, produces = {"application/json",
                                                                                                  "application/xml"})
    public Person person2(@PathVariable("name") String name,
                          @PathVariable("telefon") String phone,
                          @PathVariable("age") int yas) {
        Person person = new Person();
        person.setName(name);
        person.setPhone(phone);
        person.setAge(yas);
        return person;
    }

    @RequestMapping(path = "/p3", method = RequestMethod.POST, produces = {"application/json",
                                                                           "application/xml"})
    public Person person3(@RequestParam("isim") String name,
                          @RequestParam("tel") String telefon,
                          @RequestParam("yas") int age)

    {
        Person person = new Person();
        person.setName(name);
        person.setPhone(telefon);
        person.setAge(age);
        return person;
    }

    @RequestMapping(path = "/p4", method = RequestMethod.POST, produces = {"application/json",
                                                                           "application/xml"})
    public Person person4(@RequestHeader("isim") String name,
                          @RequestHeader("tel") String telefon,
                          @RequestHeader("yas") int age)

    {
        Person person = new Person();
        person.setName(name);
        person.setPhone(telefon);
        person.setAge(age);
        return person;
    }

    @RequestMapping(path = "/p5", method = RequestMethod.POST, produces = {"application/json",
                                                                           "application/xml"}, consumes = {"application/json",
                                                                                                           "application/xml"})
    public Person person4(@RequestBody Person personRequest) {
        Person person = new Person();
        person.setName(personRequest.getName());
        person.setPhone(personRequest.getPhone());
        person.setAge(personRequest.getAge());
        return person;
    }

}
