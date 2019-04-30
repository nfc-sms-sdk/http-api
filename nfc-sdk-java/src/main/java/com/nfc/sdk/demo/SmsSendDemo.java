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
 * @Description 发送普通短信
 * @date 2019/4/29 11:10 AM
 **/

public class SmsSendDemo {

    public static void main(String[] args) {
        //TODO 从 ${com.nfc.sdk.demo.ObtainTokenDemo} 获取
        String token="3i3TRCOuNIoqgeYqUBpk1f4MGiQ2EKv-DPquHQhZSuBnfVs6HItO02f2iRoliQpWiHV69wVVtWKh_YoyAD59ZhXDFLfMpXxKZRun0BuqpYY=";
        //修改为您要发送的手机号,多个以逗号分开
        String phoneNumbers = "13052253109";
        String sign = "张三";
        //设置您要发送的内容：其中“【】”中括号为运营商签名符号，多签名内容前置添加提交
        String content = "【张三】我的金额还剩余100000。如非本人操作，请忽略。";
        Map<String, Object> params = new HashMap<>();
        params.put("token", token);
        params.put("phoneNumbers", phoneNumbers);
        params.put("sign", sign);
        params.put("content", content);
        String open = HttpclientHelper.open(UrlHelper.SMS_SEND, params, MethodHelper.POST);
        System.out.println(open);

    }
}
