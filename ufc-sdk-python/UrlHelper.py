

"""
    author HanKeQi
    请求URL
"""

BASE_URL = "http://openapi.gateway.paasw.com"

#获取token
URL_TOKEN = "%s/api/token" % (BASE_URL)

#普通短信发送
SMS_SEND = "%s/sms/send" % (BASE_URL)

#模板短信发送
SMS_TEMPLATE = "%s/sms/sendTemplate" % (BASE_URL)

#上行
URL_UP = "%s/sms/smsUp" % (BASE_URL)

#回执
URL_DELIVER = "%s/sms/deliver" % (BASE_URL)

#余额
URL_BALANCE = "%s/sms/balance" % (BASE_URL)


