package com.training.spring.springadv;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

// @Component
public class BeanPostPro implements BeanPostProcessor{
    @Override
    public Object postProcessBeforeInitialization(Object o,
                                                  String s) throws BeansException {
        System.out.println(o);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o,
                                                 String s) throws BeansException {
        System.out.println(o);
        return o;
    }
}
