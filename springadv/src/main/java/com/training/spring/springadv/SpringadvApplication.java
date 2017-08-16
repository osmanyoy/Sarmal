package com.training.spring.springadv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.training.Person;

import java.lang.reflect.Field;

//@SpringBootApplication(scanBasePackages = {"org.training","com.training"})
@SpringBootApplication
@ServletComponentScan
public class SpringadvApplication implements ApplicationRunner{

    @Autowired
    private Logger logger ;


    @Autowired
    @DeviceBean
    private Device device1;

    @Autowired
    private Person person;


    @MyFirstAnno(defVal = 10, name = "Nil")
    private int intVal;

    public static String[] arguments;

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        arguments = args;
        Class<SpringadvApplication> springadvApplicationClass = SpringadvApplication.class;
        SpringadvApplication springadvApplication = springadvApplicationClass.newInstance();
        Field[] declaredFields = springadvApplicationClass.getDeclaredFields();
        for (Field field : declaredFields) {
            MyFirstAnno annotation = field.getAnnotation(MyFirstAnno.class);
            if (annotation != null){
                String name = annotation.name();
                int defVal = annotation.defVal();
                field.set(springadvApplication,defVal);
            }
        }
        System.out.println(springadvApplication);
        ConfigurableApplicationContext context = SpringApplication.run(SpringadvApplication.class,
                                                                   args);
        SpringadvApplication bean = context.getBean(SpringadvApplication.class);
        System.out.println(bean.device1.getName());
        if (bean.logger.isInfoEnabled()) {
            bean.logger.info("osman : " + bean.device1.getName());
        }
        //  SpringApplication.exit(context);
    }

    @Override
    public String toString() {
        return "SpringadvApplication{" + "intVal=" + intVal + '}';
    }

    @Autowired
    private Environment environment;


    @Override
    public void run(ApplicationArguments applicationArguments) throws
                                                               Exception {
        System.getProperties().setProperty("info.test","test str");
    }
}
