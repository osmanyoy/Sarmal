package com.trainig.spring.rest;

import com.trainig.spring.AppProp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    @Qualifier("mevam")
    private AppProp appProp;

    @RequestMapping(value = "/hello/{prop}", method = RequestMethod.POST, produces = {"application/xml",
                                                                                      "application/json"})
    public AppProp helloWorld(@PathVariable("prop") int intVal,
                              @RequestParam("str") String str,
                              @RequestHeader("ip") String ip) {
        appProp.setPort(intVal);
        appProp.setServerName(str);
        appProp.setConnectionIP(ip);

        return appProp;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.PUT, produces = {"application/xml",
                                                                              "application/json"}, consumes = {"application/xml",
                                                                                                               "application/json"})
    public AppProp helloWorld2(@RequestBody AppProp appProp) {
        if (appProp.getPort() > 1000){
            throw new IllegalArgumentException("Yanlış");
        }
        return appProp;
    }


    @RequestMapping(value = "/hello", method = RequestMethod.PATCH, produces = {"application/xml",
                                                                              "application/json"}, consumes = {"application/xml",
                                                                                                               "application/json"})
    public ResponseEntity<?> helloWorld3(@RequestBody AppProp appProp) {
        if (appProp.getPort() > 1000){
            ReqError reqError = new ReqError();
            reqError.setCause(101);
            reqError.setDesc("Port Yanlış girildi");
            return ResponseEntity.badRequest().body(reqError);
        }
        return ResponseEntity.ok(appProp);
    }



    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String exHand(Exception ex){
        return "Error oluştu local";
    }

}
