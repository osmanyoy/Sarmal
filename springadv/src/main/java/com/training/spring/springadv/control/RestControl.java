package com.training.spring.springadv.control;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@RestController
public class RestControl {

    @RequestMapping(value = "/hello",
                    method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }


    @RequestMapping(value = "/cust/{identity}",
                    method = RequestMethod.GET,
                    produces = {"application/json",
                                "application/xml"})
    public ResponseEntity<?> getCustomer(@PathVariable("identity") long id,
                                         @RequestParam("age") int age,
                                         @RequestHeader("abc") String abc,
                                         HttpServletRequest servletRequest,
                                         HttpServletResponse servletResponse,
                                         Principal principal) {
        if (age > 120) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(Error.createBadRequestError("bu şu olmaz"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(new Customer().setAge(47)
                                                 .setName(abc)
                                                 .setId(id));
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public String myExceptionHandler(Exception ex) {
        return ex.getMessage();
    }

    public static class Error {
        private int    cause;
        private String desc;

        public static Error createBadRequestError(String desc) {
            Error error = new Error();
            error.setCause(10);
            error.setDesc(desc);
            return error;
        }

        public int getCause() {
            return cause;
        }

        public void setCause(int cause) {
            this.cause = cause;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

}
