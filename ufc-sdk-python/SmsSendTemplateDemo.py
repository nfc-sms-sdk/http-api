# -*- coding: UTF-8 -*-
import requests
import UrlHelper


"""
    author HanKeQi
    发送模板短信
"""
# TODO 从 ${ObtainTokenDemo.py} 获取
token = "7aAwkbzy3T3vNGKbtULC548WbV3F0omXHrZYQ2Ut343uvghLboPfb2sAhSIs5jrH0B_lZehQMlTKQxK0tmJ3QxmbG-hWN7EAPfH8B5DifrU="
#修改为您要发送的手机号,多个以逗号分开
phoneNumbers = "13052253109"
#签名
sign = "厚本金融"
#内容，自定义，可前后签名 必须带【】
content = "【厚本金融】验证码${code}，您正在注册成为新用户，感谢您的支持！"
#参数
paramJson="[{\"code\" : \"99995555\"}]"
#模板ID
templateId = "2619809535360000";
jsonParams = {"token" : token, "phoneNumbers" : phoneNumbers, "sign" : sign, "content" : content, "templateId" : templateId, "paramJson" : paramJson}
requests = requests.post(UrlHelper.SMS_TEMPLATE, data=jsonParams)
print(requests.content.decode('utf-8'))