package com.training.spring.websocket;

public class HelloMessage {

	private String name;

	public HelloMessage() {
	}

	public HelloMessage(final String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HelloMessage [name=" + this.name + "]";
	}

}
