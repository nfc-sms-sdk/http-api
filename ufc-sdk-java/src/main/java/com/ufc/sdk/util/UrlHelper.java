/**
 * Project Name:
 * Class Name:com.ufc.sdk.util.java
 * <p>
 * Version     Date         Author
 * -----------------------------------------
 * 1.0    2015年11月17日      HanKeQi
 * <p>
 * Copyright (c) 2019, ufc All Rights Reserved.
 */
package com.ufc.sdk.util;

/**
 * @author HanKeQi
 * @Description 公用URL
 * @date 2019/4/29 10:41 AM
 **/

public class UrlHelper {


    private static final String BASE_URL = "http://openapi.gateway.paasw.com";

    /**
     * 获取token
     */
    public static final String URL_TOKEN = String.format("%s/api/token", BASE_URL);

    /**
     * 普通短信发送
     */
    public static final String SMS_SEND = String.format("%s/sms/send", BASE_URL);

    /**
     * 模板短信发送
     */
    public static final String SMS_TEMPLATE = String.format("%s/sms/sendTemplate", BASE_URL);

    /**
     * 上行
     */
    public static final String URL_UP = String.format("%s/sms/smsUp", BASE_URL);

    /**
     * 回执
     */
    public static final String URL_DELIVER = String.format("%s/sms/deliver", BASE_URL);

    /**
     * 余额
     */
    public static final String URL_BALANCE = String.format("%s/sms/balance", BASE_URL);


}
