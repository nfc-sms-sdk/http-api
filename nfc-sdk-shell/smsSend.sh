#!/bin/sh
# account and password can be change to what you wanna!
#author HanKeQi
#
#参数的配置

url="http://openapi.gateway.paasw.com/sms/send"
#从token.sh获取
token="3i3TRCOuNIoqgeYqUBpk1f4MGiQ2EKv-DPquHQhZSuBnfVs6HItO02f2iRoliQpWTeJLXypEV1LNpU6OjoLExDgJniMfo6g4pmyOZvCbKUE="
#修改为您要发送的手机号,多个以逗号分开
phoneNumbers="13000000000"
sign="NFC"

#设置您要发送的内容：其中“【】”中括号为运营商签名符号
content="【NFC】我的金额还剩余100000。如非本人操作，请忽略。"
echo "send sms:"

data="token=$token&phoneNumbers=$phoneNumbers&sign=$sign&content=$content"

echo $data
curl -d $data $url




