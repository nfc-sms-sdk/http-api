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

import com.nfc.sdk.util.HttpclientHelper;
import com.nfc.sdk.util.MethodHelper;
import com.nfc.sdk.util.UrlHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HanKeQi
 * @Description
 * @date 2019/4/29 11:36 AM
 **/

public class SmsSendTemplateDemo {

    public static void main(String[] args) {

        //TODO 从 ${com.nfc.sdk.demo.ObtainTokenDemo} 获取
        String token="7aAwkbzy3T3vNGKbtULC548WbV3F0omXHrZYQ2Ut343uvghLboPfb2sAhSIs5jrHcTlZ7LtOU8F5AoVagu4fal42-f7bS68GYTGxvTEVAHo=";
        //修改为您要发送的手机号,多个以逗号分开
        String phoneNumbers = "13000000000";
        String sign = "NFC";
        //设置您要发送的内容：其中“【】”中括号为运营商签名符号
        String content = "【NFC】验证码${code}，您正在注册成为新用户，感谢您的支持！";
        String templateId = "2619809535360000";
        String paramJson="[{\"code\" : \"99995555\"}]";
        Map<String, Object> params = new HashMap<>();
        params.put("token", token);
        params.put("phoneNumbers", phoneNumbers);
        params.put("sign", sign);
        params.put("content", content);
        params.put("templateId", templateId);
        params.put("paramJson", paramJson);
        String open = HttpclientHelper.open(UrlHelper.SMS_TEMPLATE, params, MethodHelper.POST);
        System.out.println(open);

    }
}
