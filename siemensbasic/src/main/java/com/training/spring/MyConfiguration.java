package com.training.spring;

import edu.ytu.TestObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:core.properties")
public class MyConfiguration {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private Environment environment;

    @Bean("kisiYarat")
    public Person personYarat() {
        return new Person();
    }

    @Bean
    public TestObj createTestObj() {
        return new TestObj();
    }

    @Bean
    @ImplV1
    public IMyInterface getInterfaceImpl1() {
        return new MyImpl1();
    }

    @Bean
    public IMyInterface getInterfaceImpl2() {
        return new MyImpl2();
    }

    @Bean
    public IMyInterface getInterfaceImpl3() {
        return new MyImpl3();
    }

    @Bean
    public IMyInterface getInterfaceImpl(@Value("${myinterface.index}") int index) {
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("myinterface.index");
        int index2 = Integer.parseInt(property);

        switch (index) {
            case 1:
                return new MyImpl1();
            case 2:
                return new MyImpl2();
            case 3:
                return new MyImpl3();
            default:
                return new MyImpl1();

        }
    }

    @Bean
    public IMyInterface getInterfaceImplFromBean(@Value("#{myInterfaceChooser.chooseInterface()}") int index) {

        MyInterfaceChooser myInterfaceChooser = (MyInterfaceChooser)context.getBean("myInterfaceChooser");
        int index2 = myInterfaceChooser.chooseInterface();

        switch (index) {
            case 1:
                return new MyImpl1();
            case 2:
                return new MyImpl2();
            case 3:
                return new MyImpl3();
            default:
                return new MyImpl1();

        }
    }

}
