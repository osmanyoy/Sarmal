package com.allianz.training.wire;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("V3")
public class ExecuteV3 implements IExecute {

	@Override
	public String exec() {
		return "V3";
	}

}
