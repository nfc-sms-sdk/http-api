#!/bin/sh
# account and password can be change to what you wanna!
#author HanKeQi
#
#参数的配置,登录ufc paasw平台获取
appId="xxxxx"                       #修改为您的API账号
secret="xxxx"                      #修改为您的API密码
url="http://openapi.gateway.paasw.com/api/token?appId=$appId&secret=$secret"

echo "get token url = $url"

curl  GET  $url
#这里会会获取token  举例返回{"code":"10000","message":"操作成功","expires_in":7200,"token":"3i3TRCOuNIoqgeYqUBpk1f4MGiQ2EKv-DPquHQhZSuBnfVs6HItO02f2iRoliQpWjd2lUwcdSKVaVxiMIY7qqrv8LO3qJgnNDp5Je4U="}



