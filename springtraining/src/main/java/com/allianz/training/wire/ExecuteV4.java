package com.allianz.training.wire;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@ExecuteChooser
public class ExecuteV4 implements IExecute {

	@Override
	public String exec() {
		return "V4";
	}

}
