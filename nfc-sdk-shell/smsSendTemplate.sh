#!/bin/sh
# account and password can be change to what you wanna!
#author HanKeQi
#
#参数的配置

url="http://openapi.gateway.paasw.com/sms/sendTemplate"
#从token.sh获取
token="3i3TRCOuNIoqgeYqUBpk1f4MGiQ2EKv-DPquHQhZSuBnfVs6HItO02f2iRoliQpWTeJLXypEV1LNpU6OjoLExDgJniMfo6g4pmyOZvCbKUE="
#修改为您要发送的手机号,多个以逗号分开
phoneNumbers="13052253109"
sign="厚本金融"
# 设置您要发送的内容：其中“【】”中括号为运营商签名符号，多签名内容前置添加提交
content="【厚本金融】你的验证码是${2019}"

paramJson="paramJson=[{\"2012\" : \"99995555\"}]"

templateId="2073078389013504"
echo "send sms:"

data="token=$token&phoneNumbers=$phoneNumbers&sign=$sign&content=$content&templateId=$templateId"

echo $data
curl -d $data --data $paramJson $url



