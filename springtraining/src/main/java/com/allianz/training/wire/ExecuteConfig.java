package com.allianz.training.wire;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class ExecuteConfig {

	@Bean(name= {"test1","test2"})
	@Lazy
	@Qualifier("configExecute")
	public IExecute createExecute(InjectionPoint injectionPoint) {
		Class<?> declaringClass = injectionPoint.getMember().getDeclaringClass();
		System.out.println(declaringClass);
		return new ExecuteV4();
				
	}
	
}
