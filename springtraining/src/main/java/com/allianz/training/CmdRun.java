package com.allianz.training;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class CmdRun implements CommandLineRunner{

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("Command line runner started ...");
	}

}
