package main


/**
	@author HanKeQi
	公共参数
 */
const BASE_URL = "http://openapi.gateway.paasw.com"


//获取token
const   URL_TOKEN = BASE_URL + "/api/token"

//普通短信发送
const SMS_SEND = BASE_URL + "/sms/send"

//模板短信发送
const SMS_TEMPLATE = BASE_URL + "/sms/sendTemplate"

//上行
const URL_UP = BASE_URL + "/sms/smsUp"

//回执
const URL_DELIVER = BASE_URL + "/sms/deliver"

//余额
const URL_BALANCE = BASE_URL + "/sms/balance"