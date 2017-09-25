package com.allianz.training;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Person implements InitializingBean, BeanNameAware, ApplicationContextAware,DisposableBean{

	private String name;
	private String surname;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Init bean callback");
	}

	@Override
	public void setBeanName(String bName) {
		System.out.println("My bean name : " + bName);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

	}

	@Override
	public void destroy() throws Exception {
		
	}

}
