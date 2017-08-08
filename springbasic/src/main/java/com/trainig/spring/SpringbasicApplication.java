package com.trainig.spring;

import com.trainig.spring.myimpl.IMyInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import javax.annotation.PostConstruct;


//@SpringBootApplication(scanBasePackages = {"com.trainig.spring","org.trainig"})
@SpringBootApplication
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.trainig.spring","org.trainig"},
//		excludeFilters = {@ComponentScan.Filter(
//				type = FilterType.CUSTOM,
//				classes = {TypeExcludeFilter.class}
//		), @ComponentScan.Filter(
//				type = FilterType.CUSTOM,
//				classes = {AutoConfigurationExcludeFilter.class}
//		)}
//)

public class SpringbasicApplication implements ApplicationRunner{

	//@Autowired
	// @Qualifier("nevam")
	//@Coz
	@Autowired
	private AppProp test2 ;

	@Autowired
	@Qualifier("myInterface3")
	private IMyInterface myInterface;

//	@Autowired
//	public SpringbasicApplication@Qualifier("nevam") AppProp test2){
//		this.test2 = test2;
//	}

	public SpringbasicApplication(){
	}

	@PostConstruct
	public void init(){
		System.out.println(this.test2.getServerName());
	}

	public static void main(String[] args) {

		//		Class<AppProp> appPropClass = AppProp.class;
		//		PropertySource annotation = appPropClass.getAnnotation(PropertySource.class);
		//		String fileName = annotation.fileName();
		ConfigurableApplicationContext context = SpringApplication.run(SpringbasicApplication.class,
																   args);

		System.out.println("Ayağa kalkıyorum");

		SpringbasicApplication bean = context.getBean(SpringbasicApplication.class);
		SpringbasicApplication bean2 = (SpringbasicApplication)context.getBean("springbasicApplication");

		System.out.println("AppProp : " + bean.test2);
		System.out.println(bean.myInterface.execute());



	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		System.out.println("AYağa kalktım");
	}
}
