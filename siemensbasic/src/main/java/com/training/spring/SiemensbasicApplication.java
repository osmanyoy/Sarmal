package com.training.spring;

import edu.ytu.TestObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// @SpringBootApplication(scanBasePackages = {"edu.ytu","com.training.spring"})
@SpringBootApplication
public class SiemensbasicApplication {

	@Autowired
	@ImplV1
	private IMyInterface myInterface;

	private Person personFromConstruct;
	private Employee employee;

	@Autowired
	private TestObj testObj;

	@Autowired
	public SiemensbasicApplication(@Qualifier("kisi") Person per,Employee employee){
		personFromConstruct = per;
		// Yanlış --> System.out.println("Person : " + person.getName());
		this.employee = employee;
	}

	@Autowired
	private Person kisi;

	@Autowired
	@Qualifier("personYarat")
	private Person person2;

	private Person person3;

	public Person getPerson() {
		return kisi;
	}

	@Autowired
	@Qualifier("kisi")
	public void personKoy(Person per){
		person3 = per;
	}

	@Autowired
	public void setPerson(Person kisi) {
		kisi.setPhone("455353453");
		kisi.setName("Default");
		this.kisi = kisi;
	}

	public Person getPerson2() {
		return person2;
	}

	public void setPerson2(Person person2) {
		this.person2 = person2;
	}

	@PostConstruct
	public void basla(){
		kisi.setName("osman");
		kisi.setPhone("834387328");
		System.out.println("Person : " + kisi);
	}

	@PreDestroy
	public void olmedenIOnce(){
		System.out.println("Person : " + kisi + " ölüyor");
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SiemensbasicApplication.class,
																   args);
		// SiemensbasicApplication siemensbasicApplication = new SiemensbasicApplication();
		SiemensbasicApplication siemensbasicApplication = context.getBean(SiemensbasicApplication.class);

	}
}
