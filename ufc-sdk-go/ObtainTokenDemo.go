package main

import (
	"fmt"
	"io/ioutil"
	"net/http"
)

/**
	@author HanKeQi
	获取token
*/
 func main() {
	var appId = "xxxxxx"     //系统appId
	var secret = "xxxxx" //系统secret
	res, err := http.Get(URL_TOKEN + "?appId=" + appId + "&secret=" + secret)
	if err != nil {
		fmt.Println(err.Error())
		return
	}
	defer res.Body.Close()
	 body, err := ioutil.ReadAll(res.Body)


	 fmt.Println(string(body))
	 //返回json
	 //{"code":"10000","message":"操作成功","expires_in":7200,
	 // "token":"7aAwkbzy3T3vNGKbtULC548WbV3F0omXHrZYQ2Ut343uvghLboPfb2sAhSIs5jrHAaKyejzi0X39i_Ki4Kh1zgMDVqloSidlmKjHLT67P60="}
}
