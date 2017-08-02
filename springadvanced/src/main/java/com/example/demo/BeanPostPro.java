package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by Osman on 31.07.2017.
 */
public class BeanPostPro implements BeanPostProcessor{
    @Override
    public Object postProcessBeforeInitialization(Object o,
                                                  String s) throws BeansException {
        System.out.println("Before Init : " + s);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o,
                                                 String s) throws BeansException {
        System.out.println("After Init : " + s);
        return o;
    }
}
