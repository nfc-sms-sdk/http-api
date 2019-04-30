/**
 * Project Name:
 * Class Name:com.nfc.sdk.demo.java
 * <p>
 * Version     Date         Author
 * -----------------------------------------
 * 1.0    2015年11月17日      HanKeQi
 * <p>
 * Copyright (c) 2019, nfc All Rights Reserved.
 */
package com.nfc.sdk.demo;

import com.nfc.sdk.util.MethodHelper;
import com.nfc.sdk.util.HttpclientHelper;
import com.nfc.sdk.util.UrlHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HanKeQi
 * @Description
 * @date 2019/4/29 10:38 AM
 **/

public class ObtainTokenDemo {


    public static void main(String[] args) {

        //两个参数请登录nfc系统查看
        String appId = "xxxxx";  //系统appId
        String secret = "xxxx"; //系统secret
        Map<String, Object> params = new HashMap<>();
        params.put("appId", appId);
        params.put("secret", secret);
        String open = HttpclientHelper.open(UrlHelper.URL_TOKEN, params, MethodHelper.GET);
        System.out.println(open);
        /**
         * 返回正确参数

         {"code":"10000","message":"操作成功","expires_in":7200,
         "token":"3i3TRCOuNIoqgeYqUBpk1f4MGiQ2EKv-DPquHQhZSuBnfVs6HItO02f2iRoliQpWiHV69wVVtWKh_YoyAD59ZhXDFLfMpXxKZRun0BuqpYY="}
         */




    }



}
