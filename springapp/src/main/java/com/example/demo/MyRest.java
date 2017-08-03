package com.example.demo;

import com.example.demo.integration.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.security.Principal;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MyRest {

    private static final String SIEMENS_FIRST_COUNTER = "siemens.first.counter";
    private static final String SIEMENS_FIRST_GAUGE   = "siemens.first.gauge";

    private AtomicInteger mCount = new AtomicInteger();
    private int mcount2;

    @Autowired
    private PublicSayicilar publicSayicilar;

    private synchronized int increase() {
        return ++mcount2;
    }

    private CounterService counterService;
    private GaugeService   gaugeService;

    @Autowired
    public MyRest(CounterService counterService,
                  GaugeService gaugeService) {
        this.counterService = counterService;
        this.gaugeService = gaugeService;
        this.counterService.reset(SIEMENS_FIRST_COUNTER);
    }

    @RequestMapping("/test/{str}")
    public String mello(@PathVariable("str") String str) {
        return "hello : " + str;
    }

    @PreAuthorize("hasRole('ADMIN')")
    // @PreAuthorize("#oauth2.hasScope('read')")
    // @MySecurity(role="ADMIN")
    @RequestMapping("/hello")
    public String hello(HttpServletRequest servletRequest, HttpServletResponse servletResponse, Principal principal) {
        int counter = mCount.incrementAndGet();
        int increase = increase();

        Collection<Metric<?>> metrics = publicSayicilar.metrics();
        for (Metric<?> m : metrics) {
            m.increment(1);
        }

        gaugeService.submit("test.gauge",
                            increase);
        gaugeService.submit(SIEMENS_FIRST_GAUGE,
                            counter);
        this.counterService.increment(SIEMENS_FIRST_COUNTER);
        return "Hello world 5";
    }

    @RequestMapping(value = "/person",method = RequestMethod.GET)
    public Person person() {
        Person person = new Person();
        person.setName("osi");
        person.setSurname("mosi");
        person.setAge(45);
        return person;

    }

    @RequestMapping(path = "/hello2/{name}", method = RequestMethod.PUT,  produces = {"application/json",
                                                                                                                    "application/xml"})
    public Product hello(@PathParam("name") String name,
                         @RequestParam("ver") String version,
                         @RequestHeader("int") int intVal) {
        return new Product().setIntVal(intVal)
                            .setName(name)
                            .setVesion(version);

    }

    @RequestMapping(path = "/hello3", method = RequestMethod.PUT, consumes = {"application/json",
                                                                                    "application/xml"}, produces = {"application/json",
                                                                                                                    "application/xml"})
    public Product hello2(@RequestBody  Product product) {
        return new Product().setIntVal(product.getIntVal())
                            .setName(product.getName())
                            .setVesion(product.getVesion());

    }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.PUT, consumes = {"application/json",
                                                                                    "application/xml"}, produces = {"application/json",
                                                                                                                    "application/xml"})
    public ResponseEntity<Object> hello3(Product product) {
        if (product != null){
            return ResponseEntity.ok(new Product().setIntVal(product.getIntVal())
                                                                                           .setName(product.getName())
                                                                                           .setVesion(product.getVesion()));
       }
       Error error = new Error();
        error.setCause(100);
        error.setDescription("desc");
        ResponseEntity<Object> errorResponseEntity = new ResponseEntity<Object>(error,
                                                                              HttpStatus.CONFLICT);
        return errorResponseEntity;
    }

}
