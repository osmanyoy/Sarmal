package com.allianz.training.wire;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("factoryTest")
public class ExecuteFactory implements FactoryBean<IExecute> {

	@Override
	public IExecute getObject() throws Exception {
		return new ExecuteV5();
	}

	@Override
	public Class<?> getObjectType() {
		return IExecute.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
