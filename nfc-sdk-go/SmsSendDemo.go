package main

import (
	"fmt"
	"io/ioutil"
	"net/http"
	"net/url"
)

/**
	@author HanKeQi
	普通短信发送
*/
func main()  {

	//TODO token 从 ${ObtainTokenDemo.go}获取
	var token = "7aAwkbzy3T3vNGKbtULC548WbV3F0omXHrZYQ2Ut343uvghLboPfb2sAhSIs5jrHAaKyejzi0X39i_Ki4Kh1zgMDVqloSidlmKjHLT67P60="
	//修改为您要发送的手机号,多个以逗号分开
	var phoneNumbers = "13000000000";
	//签名 不带【】
	var sign = "NFC"
	//设置您要发送的内容：其中“【】”中括号为运营商签名符号
	var content = "【NFC】我的金额还剩余100000。如非本人操作，请忽略。"

	values := url.Values{"token": {token}, "phoneNumbers": {phoneNumbers}, "sign" : {sign}, "content" : {content}}
	resp, err := http.PostForm(SMS_SEND, values)
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