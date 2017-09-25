package com.allianz.training.wire;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ExecuteV5 implements IExecute {

	@Override
	public String exec() {
		return "V5";
	}

}
