package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class SpringadvancedApplication implements ApplicationRunner, InitializingBean, BeanNameAware, ApplicationContextAware {

    private final static Logger logger = LoggerFactory.getLogger(SpringadvancedApplication.class);

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Device device;

    @Autowired
    private Device device1;

    @Autowired
    private Device device2;

    @Autowired
    @Qualifier("deviceMethod1")
    private Device device3;

    @Autowired
    @Qualifier("ahmet")
    private Device device4;

    @Autowired
    @Mehmet
    private Device device5;


    @Autowired
    public SpringadvancedApplication(@Mehmet Device device6) {
        System.out.println(device6.getName());
    }

    @PostConstruct
    public void init() {
        System.out.println(device4.getName());
    }

    @PreDestroy
    public void destroy() {
        System.out.println(device4.getName());
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringadvancedApplication.class,
                                                                       args);

        SpringadvancedApplication bean = context.getBean(SpringadvancedApplication.class);
        String method = bean.method();
        System.out.println("Method : " + method);
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println("Application ayağa kalktı");
        if (logger.isDebugEnabled()) {
            logger.debug("Application ayağa kalktı" + applicationArguments);
        }
    }

    public String method() {
        return "hello world";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(device1.getName());
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("Bean yaratılıyor : " + s);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
