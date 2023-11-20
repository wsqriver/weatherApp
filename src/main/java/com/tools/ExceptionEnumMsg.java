package com.tools;

public enum ExceptionEnumMsg {
    //common model
    CITY_APPLICATION_ERROR("COMMON10000","city application error"),

    //city application model
    NOTFOUNDCITY("CITY10000","not found city");
    private String  errorCode;
    private String errorMSG;

    ExceptionEnumMsg(String i, String s) {
        this.errorCode=i;
        this.errorMSG=s;
    }
    public String getErrorMSG() {
        return errorMSG;
    }
    public String getErrorCode() {
        return errorCode;
    }

}



