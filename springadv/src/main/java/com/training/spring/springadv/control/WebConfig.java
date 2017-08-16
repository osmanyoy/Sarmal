package com.training.spring.springadv.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;
import java.util.Arrays;

@Configuration
public class WebConfig {


//    @Bean
//    public FilterRegistrationBean filterRegistrationBean(MyFirstFilter myFirstFilter){
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(myFirstFilter);
//        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST);
//        filterRegistrationBean.setUrlPatterns(Arrays.asList("/filterTest/*","/hello/*"));
//        filterRegistrationBean.setOrder(100);
//        filterRegistrationBean.setEnabled(true);
//        filterRegistrationBean.addInitParameter("osman","yay");
//        return filterRegistrationBean;
//    }

}
