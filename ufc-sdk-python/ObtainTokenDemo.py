# -*- coding: UTF-8 -*-
import requests
import UrlHelper

"""
    author HanKeQi
    获取token 
"""
#两个参数请登录nfc系统查看
appId = 'xxxxx' #系统appId
secret = 'xxxxx' #系统secret
params = {"appId" : appId, "secret" : secret}
requests = requests.get(UrlHelper.URL_TOKEN, params)
print(requests.content.decode("utf-8"))  # 返回字节形式
