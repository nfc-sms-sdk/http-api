package main

import (
"fmt"
"io/ioutil"
"net/http"
)

/**
	@author HanKeQi
	查询余额
*/
func main() {
	//TODO token 从 ${ObtainTokenDemo.go}获取
	var token = "7aAwkbzy3T3vNGKbtULC548WbV3F0omXHrZYQ2Ut343uvghLboPfb2sAhSIs5jrHAaKyejzi0X39i_Ki4Kh1zgMDVqloSidlmKjHLT67P60="
	res, err := http.Get(URL_BALANCE + "?token=" + token)
	if err != nil {
		fmt.Println(err.Error())
		return
	}
	defer res.Body.Close()
	body, err := ioutil.ReadAll(res.Body)


	fmt.Println(string(body))

}

