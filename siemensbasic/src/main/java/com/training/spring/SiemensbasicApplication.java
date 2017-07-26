package com.training.spring;

import com.training.spring.customer.*;
import com.training.spring.data.CustomerCustomRepository;
import com.training.spring.data.CustomerRepository;
import edu.ytu.TestObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

// @SpringBootApplication(scanBasePackages = {"edu.ytu","com.training.spring"})
@SpringBootApplication
public class SiemensbasicApplication implements ApplicationRunner {

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
	@Qualifier("kisiYarat")
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

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerCustomRepository customerCustomRepository;


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

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		Customer customer = new Customer();
		customer.setName("osman");
		customer.setSurname("yay");
		customer.setAge(47);

		customer.setPassword("osman12");
		customer.setUsername("osman");

		Adress adress = new Adress();
		adress.setCity("Adana");
		adress.setPostalcode(100101);
		adress.setStreetName("Atatürk");
		adress.setTown("Ceyhan");

		customer.setAdress(adress);

		PersonalData personalData = new PersonalData();

		personalData.setIdentityNumber("" + UUID.randomUUID());
		personalData.setSpouseName("Ayşe");

		customer.setPersonalData(personalData);
		// personalData.setCustomer(customer);


		List<Account> accounts = new ArrayList<>();
		accounts.add(new Account().setAccountName("osmanA").setAccountType(EAccountType.TL).setBalance(100).setCustomer(customer));
		accounts.add(new Account().setAccountName("osmanB").setAccountType(EAccountType.DOLAR).setBalance(100).setCustomer(customer));
		accounts.add(new Account().setAccountName("osmanC").setAccountType(EAccountType.EURO).setBalance(100).setCustomer(customer));

		customer.setAccounts(accounts);

		// customerCustomRepository.save2(customer);

		// customerRepository.save(customer);

		// customer.setAge(57);
		customerRepository.save(customer);

		// System.out.println(customer.getPassword());

		List<Customer> customerList = customerRepository.testMyQuery(47,
																	 "osman");
		System.out.println(customerList);
	}
}
