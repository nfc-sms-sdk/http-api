package main

import (
	"fmt"
	"io/ioutil"
	"net/http"
	"net/url"
)

/**
	@author HanKeQi
	模板短信发送
*/
func main()  {
	//TODO token 从 ${ObtainTokenDemo.go}获取
	var token = "7aAwkbzy3T3vNGKbtULC548WbV3F0omXHrZYQ2Ut343uvghLboPfb2sAhSIs5jrHAaKyejzi0X39i_Ki4Kh1zgMDVqloSidlmKjHLT67P60="
	//修改为您要发送的手机号,多个以逗号分开
	var phoneNumbers = "13052253109";
	var sign = "厚本金融";
	//设置您要发送的内容：其中“【】”中括号为运营商签名符号，多签名内容前置添加提交
	var content = "【厚本金融】验证码${code}，您正在注册成为新用户，感谢您的支持！";
	//参数
	var paramJson="[{\"code\" : \"99995555\"}]"
	//模板ID
	var templateId = "2619809535360000";
	values := url.Values{"token": {token}, "phoneNumbers": {phoneNumbers}, "sign" : {sign}, "content" : {content}, "paramJson" : {paramJson}, "templateId": {templateId}}
	resp, err := http.PostForm(SMS_TEMPLATE, values)
	if err != nil {
		// handle error
	}

	defer resp.Body.Close()

	body, err := ioutil.ReadAll(resp.Body)

	if err != nil {
		// handle error
	}
	fmt.Println(string(body))

}