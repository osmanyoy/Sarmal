package com.allianz.training.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorObject {
	private String desc;
	private int errorCode;
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	public static ErrorObject createValidationError(String desc) {
		ErrorObject errorObject = new ErrorObject();
		errorObject.setErrorCode(101);
		errorObject.setDesc(desc);
		return errorObject;
	}
	
}
