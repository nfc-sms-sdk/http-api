#!/bin/sh
# account and password can be change to what you wanna!
#author HanKeQi
#
#参数的配置

url="http://openapi.gateway.paasw.com/sms/deliver"
#从token.sh获取
token="3i3TRCOuNIoqgeYqUBpk1f4MGiQ2EKv-DPquHQhZSuBnfVs6HItO02f2iRoliQpWTeJLXypEV1LNpU6OjoLExDgJniMfo6g4pmyOZvCbKUE="
data="$url?token=$token"
echo $data
curl GET $data



