import requests
import UrlHelper


"""
    author HanKeQi
    获取上行
"""
# TODO 从 ${ObtainTokenDemo.py} 获取
token = "7aAwkbzy3T3vNGKbtULC548WbV3F0omXHrZYQ2Ut343uvghLboPfb2sAhSIs5jrH0B_lZehQMlTKQxK0tmJ3QxmbG-hWN7EAPfH8B5DifrU="
params = {"token" : token}
requests = requests.get(UrlHelper.URL_UP, params)
print(requests.content.decode('utf-8'))  # 返回字节形式
