/**
 * Project Name:
 * Class Name:com.sioo.sdk.util.java
 * <p>
 * Version     Date         Author
 * -----------------------------------------
 * 1.0    2015年11月17日      HanKeQi
 * <p>
 * Copyright (c) 2019, sioo All Rights Reserved.
 */
package com.ufc.sdk.util;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author HanKeQi
 * @Description
 * @date 2019/4/29 10:38 AM
 **/

public class HttpclientHelper {

    public static String open(String path, Map<String, Object> body, MethodHelper method) {
        URL url = null;
        try {
            StringBuilder params=new StringBuilder();
            body.forEach((key, value)->{
                params.append(key);
                params.append("=");
                try {
                    params.append(URLEncoder.encode(String.valueOf(value), "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                params.append("&");
            });
            if(params.length()>0){
                params.deleteCharAt(params.lastIndexOf("&"));
            }
            String param = path +(params.length()>0 ? "?"+params.toString() : "");
            url = new URL(param);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(method.getName());// 提交模式
            httpURLConnection.setConnectTimeout(10000);//连接超时 单位毫秒
            httpURLConnection.setReadTimeout(10000);//读取超时 单位毫秒
            // 发送POST请求必须设置如下两行
            if (MethodHelper.POST == method){
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
            }
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");

            httpURLConnection.connect();

            StringBuilder sb = new StringBuilder();
            int httpRspCode = httpURLConnection.getResponseCode();
//            if (httpRspCode == HttpURLConnection.HTTP_OK) {
                // 开始获取数据
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                br.close();
                return sb.toString();

//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
