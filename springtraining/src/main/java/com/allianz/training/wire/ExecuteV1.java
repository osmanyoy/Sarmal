package com.allianz.training.wire;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ExecuteV1 implements IExecute {

	@Override
	public String exec() {
		return "V1";
	}

}
