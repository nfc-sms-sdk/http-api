# -*- coding: UTF-8 -*-
import requests
import UrlHelper

"""
    author HanKeQi
    获取token 
"""
#两个参数请登录nfc系统查看
appId = '200001' #系统appId
secret = '123456789' #系统secret
params = {"appId" : appId, "secret" : secret}
requests = requests.get(UrlHelper.URL_TOKEN, params)
print(requests.content.decode("utf-8"))  # 返回字节形式
