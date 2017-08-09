package com.example.customer.controller;

/**
 * Created by Osman on 9.08.2017.
 */
public class ErrorResponse {
    private int cause;
    private String desc;

    public int getCause() {
        return cause;
    }

    public void setCause(int cause) {
        this.cause = cause;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static ErrorResponse createErrorResponse(int cause,String desc){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCause(cause);
        errorResponse.setDesc(desc);
        return errorResponse;
    }
}
