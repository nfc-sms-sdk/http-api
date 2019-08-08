
### API 接口

####  1: token获取接口
Https/HTTP请求方式: GET
http://openapi.gateway.paasw.com/api/token

|  参数 |  描述 | 类型  | 示例  |  是否必填 | 最大长度
| ------------ | ------------ | ------------ | ------------ | ------------ | ------------
|appId |创建应用时系统分配的唯一应用标示 |String |0189457543 |是|10
|secret |系统分配应用密钥|String |23f757bad208226ec301e117e40006ed |是 |30

不同的应用的Secret会返回不同的Token。正常情况下Token有效期为7200秒，有效期内重复获取返回相同结果。
返回值,如果由于密钥重置导致token失效开发者应该实现重试获取token的逻辑
```json
{
    "code": "10000",
    "message": "操作成功",
    "token": "k67jwkqzSqN6gtGHjo8KwrQrkfE4r6m4px5YEpjsWnYoBZxFwNzxQrxdQbzDSdkr",
     "expires_in": 7200
}
```
####  2:发送接口（普通单条发送）
Https/HTTP请求方式: POST
http://openapi.gateway.paasw.com/sms/send

|参数|描述|类型|示例|是否必填|最大长度
| ------------ | ------------ | ------------ | ------------ | ------------ | ------------
|token |用户密钥通过接口获取 |String |k67jwkqzSqN6gtGHjo8KwrQrkfE4r6m4px5YEpjsWnYoBZxFwNzxQrxdQbzDSdkr |是|200
|phoneNumbers |发送手机号，多个以,分割，最多1000|String |13651688564，13568988547 |是|1500
|sign |签名不包含【】|String|圆通快递|是|20
|content |发送内容，包含【XX】签名|String|你的快件56682551825已签收，谢谢使用|是|1000
|kind |短信类型|String|1、验证码，2、普通短信，3、营销短信。<span style="color: red">`如果配置的是支持多种类型则是必传字段!!!`</span> 单一类型不填写|仔细查看描述|1

返回参数
```json
{
    "code":"10000"
    "message":"操作成功",
    "bizId":"39036632588910887018",
}
```
bizId: 发送回执ID，可根据该ID查询提交状态，对应批次batchId。


####  3: 模板短信发送接口
Https/HTTP请求方式: POST
http://openapi.gateway.paasw.com/sms/sendTemplate

|参数|描述|类型|示例|是否必填|最大长度
| ------------ | ------------ | ------------ | ------------ | ------------ | ------------
|token |用户密钥通过接口获取|String |k67jwkqzSqN6gtGHjo8KwrQrkfE4r6m4px5YEpjsWnYoBZxFwNzxQrxdQbzDSdkr |是|200
|phoneNumbers |发送手机号，多个以,分割，最多1000|String|13651688564，13568988547 |是|1500
|paramJson|短信模板参数|String|[{"name":"paramJson"},{"name":"paramJson"}]|是|100
|templateId |短信模板ID，必须已经审核通过的模板|String|1192360392260608|是|20
|sign |签名不包含【】|String|圆通快递|是|20|
|content |发送内容|String|你的快件56682551825已签收，谢谢使用|是|1000

返回参数
```json
{
    "code":"10000"
   "message":"操作成功",
   "bizId":"39036632588910887018",
}
```

####  4: 状态(回执)查询接口
##### 1: Https/HTTP请求方式: GET
GET方式为自查
http://openapi.gateway.paasw.com/sms/deliver

| 参数|描述|类型|示例|是否必填|最大长度
| ------------ | ------------ | ------------ | ------------ | ------------ | ------------
|token |用户密钥通过接口获取 |String |k67jwkqzSqN6gtGHjo8KwrQrkfE4r6m4px5YEpjsWnYoBZxFwNzxQrxdQbzDSdkr |是|200
|sign |签名不包含【】|String|圆通快递|否|20

#####2：推送
推送数据格式
由对方提供推送接收地址
通过HTTP协议推送JSON/utf-8，，单次推送可能会包含多个状态报告结果。
```json
[
  {
    "phone_number" : "13900000001",
    "send_time" : "2017-01-01 00:00:00",
    "report_time" : "2017-01-01 00:00:00",
    "success" : true,
    "code" : "10000",//10000:用户接收成功；1：提交失败，4：失败，5：屏蔽词，6：审核驳回，7：黑/白名单，8：超频，9：未知
    "message" : "请求成功",
    "sms_size" : "1",
    "biz_id" : "39036632588910887018",
  }
]
```
返回参数
```json
{
  "code" : 10000,
  "msg" : "操作成功"
}
```

####  5: 上行查询接口
#####1: Https/HTTP请求方式: GET
GET方式为自查
http://openapi.gateway.paasw.com/sms/smsUp

|参数|描述|类型|示例|是否必填|最大长度
| ------------ | ------------ | ------------ | ------------ | ------------ | ------------
|token |用户密钥通过接口获取 |String |k67jwkqzSqN6gtGHjo8KwrQrkfE4r6m4px5YEpjsWnYoBZxFwNzxQrxdQbzDSdkr |是|64
|sign |签名不包含【】|String|圆通快递|是|20

返回参数：
可能返回多条
```json
[
  {
    "phone_number" : "18612345678",
    "send_time" : "2017-09-01 00:00:00",
    "content" : "内容",
    "sign" : "签名",
    "sequence_id" : 1234567890
  }
]
```
#####2：推送
推送数据格式
由对方提供推送接收地址
通过HTTP协议推送JSON/utf-8，，单次推送可能会包含多个状态报告结果。
```json
[
  {
    "phone_number" : "18612345678",
    "send_time" : "2017-09-01 00:00:00",
    "content" : "内容",
    "sign" : "签名",
    "sequence_id" : 1234567890
  }
]
```
返回参数
```json
{
  "code" : "10000",
  "msg" : "请求成功"
}
```

####  5: 余额查询接口
Https/HTTP请求方式: GET
http://openapi.gateway.paasw.com/sms/balance

|参数|描述|类型|示例|是否必填|最大长度|
| ------------ | ------------ | ------------ | ------------ | ------------ | ------------
|token |用户密钥通过接口获取 |String |k67jwkqzSqN6gtGHjo8KwrQrkfE4r6m4px5YEpjsWnYoBZxFwNzxQrxdQbzDSdkr |是|64|

```json
{
  "code":"10000"
  "message":"请求成功",
  "balance" : 100.00
}
```




 
#### 错误信息一览

###待更新




















