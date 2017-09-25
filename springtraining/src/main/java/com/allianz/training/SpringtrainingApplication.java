package com.allianz.training;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.allianz.test.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.allianz.training.wire.ExecuteChooser;
import com.allianz.training.wire.IExecute;

@SpringBootApplication(scanBasePackages= {"com.allianz","org.allianz"})
public class SpringtrainingApplication implements ApplicationRunner {
	
	private Person person;
	
	
	private Employee employee;
	
	@Autowired
	// @ExecuteChooser
	// @Qualifier("configExecute")
	@Qualifier("factoryTest")
	private IExecute executeV2;
	
	@Autowired
	public SpringtrainingApplication(Employee employee,ApplicationContext applicationContext) {
		this.employee = employee;
		this.employee.setName("osman");
	}
	
	@Autowired
	public void test(Person person) {
		this.person = person;
	}
	
	@PostConstruct
	public void init() {
		employee.setName("osman");
	}
	
	@PreDestroy
	public void destroy() {
		
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringtrainingApplication.class, args);
		
		SpringtrainingApplication bean = context.getBean(SpringtrainingApplication.class);
		
		
//		SpringtrainingApplication application = new SpringtrainingApplication();
		System.out.println(bean.person);
		
		String exec = bean.executeV2.exec();
		System.out.println(exec);
		
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		System.out.println("Application started......");
		
	}
}
