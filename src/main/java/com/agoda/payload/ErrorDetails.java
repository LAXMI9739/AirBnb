package com.agoda.payload;

import java.util.Date;

public class ErrorDetails {
    private String errormessage;
    private String webRequest;
    private Date date;

    public String getErrormessage() {
        return errormessage;
    }

    public String getWebRequest() {
        return webRequest;
    }

    public Date getDate() {
        return date;
    }

    public ErrorDetails(String errormessage, String webRequest, Date date ){
        this.errormessage=errormessage;
        this.webRequest=webRequest;
        this.date=date;
    }

}
