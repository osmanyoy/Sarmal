package com.training.spring.springadv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.training.MySecondConfig;
import org.training.TestObj;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
@Profile("dev")
@PropertySource("classpath:myprop.properties")
@Import(MySecondConfig.class)
@ImportResource("classpath:beans.xml")
public class AppConfig {

    private ApplicationContext applicationContext;



    @Autowired
    private Environment environment;

    @Autowired
    public AppConfig(ApplicationContext context){
        this.applicationContext = context;
    }

    @PostConstruct
    public void init(){
        System.out.println(environment.getProperty("my.prop"));
    }

    @PreDestroy
    public void dest(){

    }

    @Autowired
    private TestObj obj;

    @Value("#{valueTest.getType()}")
    private int deviceType;

    @Value("#{T(System).currentTimeMillis()}")
    private long createTime;

    @Bean
    @Scope("prototype")
    public Logger logger(InjectionPoint point){
        Class<?> declaredType = point.getMember().getDeclaringClass();
        return LoggerFactory.getLogger(declaredType);
    }

    @Lazy
    @Bean
    @Primary
    public Device dev(@Value("${my.test.prop}") int deviceType){
        return new Device();
    }

    @Bean
    @MyConditionAnno(name = "second",intVal = 10)
    public Second second(){
        return new Second();
    }

    @Autowired
    private Second second;


    @Bean
    @Qualifier("testMest")
    public Device devTest(){
        Second second = second();
        return new Device();
    }

    @Autowired
    public void myTestFunction(Device device,Second second){
        System.out.println(device);
    }

    @Bean
    @DeviceBean
    public Device devTest2(){
        return new Device();
    }


}
