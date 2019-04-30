package com.nfc.sdk.util;

/**
 * @author HanKeQi
 * @Description
 * @date 2019/4/29 10:52 AM
 **/

public enum MethodHelper {


    GET("GET"),
    POST("POST");

    private String name;

    MethodHelper(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
