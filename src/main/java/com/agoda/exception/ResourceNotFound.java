package com.agoda.exception;

public class ResourceNotFound extends RuntimeException{

    private String errormessage;

    public ResourceNotFound(String errormessage){
        super(errormessage);
    }
}
