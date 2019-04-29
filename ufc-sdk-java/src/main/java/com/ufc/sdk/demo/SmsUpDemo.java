/**
 * Project Name:
 * Class Name:com.ufc.sdk.demo.java
 * <p>
 * Version     Date         Author
 * -----------------------------------------
 * 1.0    2015年11月17日      HanKeQi
 * <p>
 * Copyright (c) 2019, ufc All Rights Reserved.
 */
package com.ufc.sdk.demo;

import com.ufc.sdk.util.HttpclientHelper;
import com.ufc.sdk.util.MethodHelper;
import com.ufc.sdk.util.UrlHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HanKeQi
 * @Description 上行
 * @date 2019/4/29 2:13 PM
 **/

public class SmsUpDemo {

    public static void main(String[] args) {
        //TODO 从 ${com.ufc.sdk.demo.ObtainTokenDemo} 获取
        String token = "7aAwkbzy3T3vNGKbtULC548WbV3F0omXHrZYQ2Ut343uvghLboPfb2sAhSIs5jrHcTlZ7LtOU8F5AoVagu4fal42-f7bS68GYTGxvTEVAHo=";
        Map<String, Object> params = new HashMap<>();
        params.put("token", token);
        String open = HttpclientHelper.open(UrlHelper.URL_UP, params, MethodHelper.GET);
        System.out.println(open);
    }
}
