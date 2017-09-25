package com.allianz.training.wire;

import org.springframework.stereotype.Component;

@Component
public class ExecuteV2 implements IExecute {

	@Override
	public String exec() {
		return "V2";
	}

}
