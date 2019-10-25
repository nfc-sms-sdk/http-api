# http-api-v2.0
短信发送相关接口v2.0版本
####  1: token获取接口(json格式)
Https/HTTP请求方式：post  
数据格式：json  
请求地址：http://openapi.gateway.paasw.com/message/token  
请求参数

|  参数 |  描述 | 类型  | 示例  |  是否必填   
| ------------ | ------------ | ------------ | ------------ | ------------  
|appId |创建应用时系统分配的唯一应用标识 |String |0189457543 |是
|secret |系统分配应用密钥|String |23f757bad208226ec301e117e40006ed |是

请求报文示例  
```json
{
    "appId":"0189457543",
    "secret":"gw7ewiz4eJ5646grg"
}
```  
返回参数

|  参数 |  描述 | 类型  | 示例  |  是否必填 |  
| ------------ | ------------ | ------------ | ------------ | ------------ |   
|code |响应码。0为成功，其它为错误码 |int |0 |是|  
|message |响应码描述|String |请求成功 |是   
|data |成功时返回数据，json对象|Object |如下 |是

data字段数据格式如下

|  参数 |  描述 | 类型  | 示例  |  是否必填 |  
| ------------ | ------------ | ------------ | ------------ | ------------ |   
|expires_in |token有效期 |int |7200 |是|  
|token |token值|String |如下 |是   

不同的应用的Secret会返回不同的Token。正常情况下Token有效期为7200秒，有效期内重复获取返回相同结果。
返回值,如果由于密钥重置导致token失效开发者应该实现重试获取token的逻辑。
返回报文示例
```json

{
    "code": 0,
    "message": "请求成功",
    "data": {
        "expires_in": 7200,
        "token":"bIAYGqdLHhyz0UyVnZAKgzvVGCx0dT8aNmLHIUUomLLg0PCR1_GXH7_snrzJG_1Id_vciCwBuH4VBhN6Wj2p1JkBmHGsFjrImnd_IRPzHM="
            }    
}

``` 
####  2: token获取接口(key=value格式)
Https/HTTP请求方式：post  
数据格式：form表单  
请求地址：http://openapi.gateway.paasw.com/message/tokenApi  
请求参数  

|  参数 |  描述 | 类型  | 示例  |  是否必填 |
| ------------ | ------------ | ------------ | ------------ | ------------ | 
|appId |创建应用时系统分配的唯一应用标示 |String |0189457543 |是|
|secret |系统分配应用密钥|String |23f757bad208226ec301e117e40006ed |是 

返回参数

|  参数 |  描述 | 类型  | 示例  |  是否必填 |
| ------------ | ------------ | ------------ | ------------ | ------------ | 
|code |响应码。0为成功，其它为错误码 |int |0 |是|
|message |响应码描述|String |请求成功 |是 
|data |成功时返回数据，json对象|Object |如下 |是

data字段数据格式如下

|  参数 |  描述 | 类型  | 示例  |  是否必填 |
| ------------ | ------------ | ------------ | ------------ | ------------ | 
|expires_in |token有效期 |int |7200 |是|
|token |token值|String |如下 |是 

不同的应用的Secret会返回不同的Token。正常情况下Token有效期为7200秒，有效期内重复获取返回相同结果。
返回值,如果由于密钥重置导致token失效开发者应该实现重试获取token的逻辑。
返回报文示例
```json

{
    "code": 0,
    "message": "请求成功",
    "data": {
    "expires_in": 7200,
    "token":"bIAYGqdLHhyz0UyVnZAKgzvVGCx0dT8aNmLHIUUomLLg0PCR1_GXH7_snrzJG_1Id_vciCwBuH4VBhN6Wj2p1JkBmHGsFjr-   Imnd_IRPzHM="
                }
}

``` 
####  3:普通发送接口（json格式）
Https/HTTP请求方式：post  
数据格式：json  
请求地址：http://openapi.gateway.paasw.com/message/send  
请求参数  

|参数|描述|类型|示例|是否必填
| ------------ | ------------ | ------------ | ------------ | ------------ |
|token |用户密钥通过接口获取 |String |k67jwkqzSqN6gtGHjo8KwrQrkfE4r6m4px5YEpjsWnYoBZxFwNzxQrxdQbzDSdkr |是
|mobile |发送手机号，多个以,分割，最多1000|String |13651688564,13568988547 |是
|msg |发送内容，包含【XX】签名|String|【圆通】你的快件56682551825已签收，谢谢使用|是
|productId |短信类型|String|1、验证码，2、普通短信，3、营销短信。|是
|extNo |拓展码(数字)|String|8888|否
|time |定时发送时间，格式为yyyy-MM-dd HH:mm:ss|String|2019-10-12 14:20:15|否

请求报文示例
```json

{ 
  "token":"pGxh639MQAVaZvOEn4uzMRkIQEw_EQh9FHi_UDmexpDJ3frYdLSVoTf63UYQG1Uhz5PIe7g_XAvqX_cRs3G0zAe6YQa",
  "mobile":"15053621452,15863254125",
  "msg":"【圆通】你的快件56682551825已签收，谢谢使用",
  "productId":"2",
  "extNo":"8888",
  "time":""
}

```
返回参数

|  参数 |  描述 | 类型  | 示例  |  是否必填 |
| ------------ | ------------ | ------------ | ------------ | ------------ | 
|code |响应码。0为成功，其它为错误码 |int |0 |是|
|message |响应码描述|String |请求成功 |是 
|data |成功时返回数据，json对象|Object |如下 |是

data字段数据格式如下

|  参数 |  描述 | 类型  | 示例  |  是否必填 |
| ------------ | ------------ | ------------ | ------------ | ------------ | 
|batchId |批次号 |Long |39036632588910887018 |是|

返回报文示例
```json
{
    "code":0,
    "message":"请求成功",
    "data":{"batchId":1234567890123456}
}

```
batchId: 发送回执ID，可根据该ID查询提交状态，对应批次batchId。

####  4:普通发送接口（key=value格式）
Https/HTTP请求方式：post  
数据格式：form表单  
请求地址：http://openapi.gateway.paasw.com/msg/send  
请求参数  

|参数|描述|类型|示例|是否必填
| ------------ | ------------ | ------------ | ------------ | ------------ |
|token |用户密钥通过接口获取 |String |k67jwkqzSqN6gtGHjo8KwrQrkfE4r6m4px5YEpjsWnYoBZxFwNzxQrxdQbzDSdkr |是
|mobile |发送手机号，多个以,分割，最多1000|String |13651688564,13568988547 |是
|msg |发送内容，包含【XX】签名|String|【圆通】你的快件56682551825已签收，谢谢使用|是
|productId |短信类型|String|1、验证码，2、普通短信，3、营销短信。|是
|extNo |拓展码(数字)|String|8888|否
|time |定时发送时间，格式为yyyy-MM-dd HH:mm:ss|String|2019-10-01 15:30:20|否

返回参数

|  参数 |  描述 | 类型  | 示例  |  是否必填 |
| ------------ | ------------ | ------------ | ------------ | ------------ | 
|code |响应码。0为成功，其它为错误码 |int |0 |是|
|message |响应码描述|String |请求成功 |是 
|data |成功时返回数据，json对象|Object |如下 |是 

data字段数据格式如下

|  参数 |  描述 | 类型  | 示例  |  是否必填 |
| ------------ | ------------ | ------------ | ------------ | ------------ | 
|batchId |批次号 |Long |39036632588910887018 |是|

返回报文示例
```json

{
    "code":0,
    "message":"请求成功",
    "data":{"batchId":1234567890123456}
}

```
batchId: 发送回执ID，可根据该ID查询提交状态，对应批次batchId。
####  5: 模板短信发送接口（json格式）
Https/HTTP请求方式：post  
数据格式：json  
请求地址：http://openapi.gateway.paasw.com/message/sendTemplate  
请求参数  

|参数|描述|类型|示例|是否必填
| ------------ | ------------ | ------------ | ------------ | ------------ |
|token |用户密钥通过接口获取 |String |k67jwkqzSqN6gtGHjo8KwrQrkfE4r6m4px5YEpjsWnYoBZxFwNzxQrxdQbzDSdkr |是
|mobile |发送手机号，多个以,分割，最多1000|String |13651688564,13568988547 |是
|templateId |模板编号|String|65644964641646|是
|params |变量参数值集合，变量数量必须大于对应模板中的变量数量，格式为JsonArray|String|{ "code":"523648", "minute":"2" }|是
|productId |短信类型|String|1、验证码，2、普通短信，3、营销短信。|是
|extNo |拓展码(数字)|String|8888|否
|time |定时发送时间，格式为yyyy-MM-dd HH:mm:ss|String|2019-10-12 14:20:15|否

请求报文示例
```json
{ 
  "token":"pGxh639MQAVaZvOEn4uzMRkIQEw_EQh9FHi_UDmexpDJ3frYdLSVoTf63UYQG1Uhz5PIe7g_XAvqX_cRs3G0zAe6Y",
  "mobile":"15050198156",
  "templateId":"4289538897476608",
  "params":{
        "code":"523648",
        "minute":"2"
    },
  "productId":"1",
  "extNo":"8866",
  "time":""
}

```
返回参数

|  参数 |  描述 | 类型  | 示例  |  是否必填 |
| ------------ | ------------ | ------------ | ------------ | ------------ | 
|code |响应码。0为成功，其它为错误码 |int |0 |是|
|message |响应码描述|String |请求成功 |是 
|data |成功时返回数据，json对象|Object |如下 |是 

data字段数据格式如下

|  参数 |  描述 | 类型  | 示例  |  是否必填 |
| ------------ | ------------ | ------------ | ------------ | ------------ | 
|batchId |批次号 |Long |39036632588910887018 |是|

返回报文示例
```json

{
    "code":0,
    "message":"请求成功",
    "data":{"batchId":1234567890123456}
}

```
batchId: 发送回执ID，可根据该ID查询提交状态，对应批次batchId。
####  6: 模板短信发送接口（key=value格式）
Https/HTTP请求方式：post  
数据格式：form表单  
请求地址：http://openapi.gateway.paasw.com/msg/sendTemplate  
请求参数  

|参数|描述|类型|示例|是否必填
| ------------ | ------------ | ------------ | ------------ | ------------ |
|token |用户密钥通过接口获取 |String |k67jwkqzSqN6gtGHjo8KwrQrkfE4r6m4px5YEpjsWnYoBZxFwNzxQrxdQbzDSdkr |是
|mobile |发送手机号，多个以,分割，最多1000|String |13651688564,13568988547 |是
|templateId |模板编号|String|65644964641646|是
|params |变量参数值集合，变量数量必须大于对应模板中的变量数量，格式为JsonArray|String|{ "code":"523648", "minute":"2" }|是
|productId |短信类型|String|1、验证码，2、普通短信，3、营销短信。|是
|extNo |拓展码(数字)|String|8888|否
|time |定时发送时间，格式为yyyy-MM-dd HH:mm:ss|String|2019-10-12 14:20:15|否

返回参数

|  参数 |  描述 | 类型  | 示例  |  是否必填 |
| ------------ | ------------ | ------------ | ------------ | ------------ | 
|code |响应码。0为成功，其它为错误码 |int |0 |是|
|message |响应码描述|String |请求成功 |是 
|data |成功时返回数据，json对象|Object |如下 |是

data字段数据格式如下

|  参数 |  描述 | 类型  | 示例  |  是否必填 |
| ------------ | ------------ | ------------ | ------------ | ------------ | 
|batchId |批次号 |Long |39036632588910887018 |是|

返回报文示例
```json

{
    "code":0,
    "message":"请求成功",
    "data":{"batchId":1234567890123456}
}

```
batchId: 发送回执ID，可根据该ID查询提交状态，对应批次batchId。
####  7: 状态(回执)查询接口（json格式）
Https/HTTP请求方式: post  
数据格式：json  
请求地址：http://openapi.gateway.paasw.com/message/deliver  
请求参数  

| 参数|描述|类型|示例|是否必填
| ------------ | ------------ | ------------ | ------------ | ------------ 
|token |用户密钥通过接口获取 |String |k67jwkqzSqN6gtGHjo8KwrQrkfE4r6m4px5YEpjsWnYoBZxFwNzxQrxdQbzDSdkr |是

请求报文示例
```json
{            
"token":"pGxh639MQAVaZvOEn4uzMRkIQEw_EQh9FHi_UDmexpDJ3frYdLSVoTf63UYQG1Uhz5PIe7g_XAvqX_cRs3G0zAe6YQa"
}
```
返回参数

|  参数 |  描述 | 类型  | 示例  |  是否必填 |
| ------------ | ------------ | ------------ | ------------ | ------------ | 
|code |响应码。0为成功，其它为错误码 |int |0 |是|
|message |响应码描述|String |请求成功 |是 
|data |回执结果集，格式为JsonArray |Object|如下 |是 
|count |状态回执数量|int |2 |是 

data字段数据格式如下

|  参数 |  描述 | 类型  | 示例  |  是否必填 |
| ------------ | ------------ | ------------ | ------------ | ------------ | 
|batchId |发送短信时返回的批次 |Long |39036632588910887018 |是|
|mobile |手机号码 |String |15236352365 |是|
|chnRptDate |回执响应时间，格式为yyyy-MM-dd HH:mm:ss |String |2019-10-01 00:00:00 |是|
|chnRptCode |运营商返回的代码 |String |DB:0141 |是|

返回报文示例
```json

{
    "code":0,
    "message":"请求成功",
    "count":2,
    "data":[
            {
                "mobile" : "13900000001", 
                "chnRptDate" : "2017-01-01 00:00:00", 
                "chnRptCode" : "DB:0141",
                "batchId" : "3903663258891088785"
            },
            {
                "mobile" : "13900000001", 
                "chnRptDate" : "2017-01-01 00:00:00", 
                "chnRptCode" : "DB:0141",
                "batchId" : "39036632588910887018"
            }
        ]
}

```

####  8: 上行查询接口（json格式）
Https/HTTP请求方式: post  
数据格式：json  
请求地址：http://openapi.gateway.paasw.com/message/mo  
请求参数

| 参数|描述|类型|示例|是否必填
| ------------ | ------------ | ------------ | ------------ | ------------ 
|token |用户密钥通过接口获取 |String |k67jwkqzSqN6gtGHjo8KwrQrkfE4r6m4px5YEpjsWnYoBZxFwNzxQrxdQbzDSdkr |是

请求报文示例
```json
{            
"token":"pGxh639MQAVaZvOEn4uzMRkIQEw_EQh9FHi_UDmexpDJ3frYdLSVoTf63UYQG1Uhz5PIe7g_XAvqX_cRs3G0zAe6YQa"
}
```
返回参数

|  参数 |  描述 | 类型  | 示例  |  是否必填 |
| ------------ | ------------ | ------------ | ------------ | ------------ | 
|code |响应码。0为成功，其它为错误码 |int |0 |是|
|message |响应码描述|String |请求成功 |是 
|data |上行短信结果集，格式为JsonArray |Object|如下 |是 
|count |上行短信数量|int |2 |是 

data字段数据格式如下

|  参数 |  描述 | 类型  | 示例  |  是否必填 |
| ------------ | ------------ | ------------ | ------------ | ------------ | 
|mobile |手机号码 |String |15236352365 |是|
|extNo |拓展码 |String |8866 |否|
|replyDate| 上行时间，格式为yyyy-MM-dd HH:mm:ss |String |2019-10-01 00:00:00 |是|
|content | 上行回复内容,utf-8编码|String |准时参加 |是|

返回报文示例
```json

{    
"code":0,
"message":"请求成功",
"count":2,    
"data":[
        {
            "mobile":"15000000002",
            "extNo":"1234567890",
            "content":"收到短信了",
            "replyDate":"2019-01-01 08:08:08"
        },
        {
            "mobile":"15000000002",
            "extNo":"1234567890",
            "content":"收到短信了",
            "replyDate":"2019-01-01 08:08:08"
        }
    ]}

```

####  9: 余额查询接口（json格式）
Https/HTTP请求方式: post  
数据格式：json  
请求地址：http://openapi.gateway.paasw.com/message/balance  
请求参数  

| 参数|描述|类型|示例|是否必填
| ------------ | ------------ | ------------ | ------------ | ------------ 
|token |用户密钥通过接口获取 |String |k67jwkqzSqN6gtGHjo8KwrQrkfE4r6m4px5YEpjsWnYoBZxFwNzxQrxdQbzDSdkr |是

请求报文示例
```json
{            
"token":"pGxh639MQAVaZvOEn4uzMRkIQEw_EQh9FHi_UDmexpDJ3frYdLSVoTf63UYQG1Uhz5PIe7g_XAvqX_cRs3G0zAe6YQa"
}
```
返回参数

|  参数 |  描述 | 类型  | 示例  |  是否必填 |
| ------------ | ------------ | ------------ | ------------ | ------------ | 
|code |响应码。0为成功，其它为错误码 |int |0 |是|
|message |响应码描述|String |请求成功 |是 
|data |成功时返回数据，json对象 |Object|如下 |是 

data字段数据格式如下

|  参数 |  描述 | 类型  | 示例  |  是否必填 |
| ------------ | ------------ | ------------ | ------------ | ------------ | 
|balance |余额 |Double |25638.23 |是|

返回报文示例
```json

{    
"code":0,    
"message":"请求成功",    
"data":{
        "balance":532
    }
 }

```
####  10: 余额查询接口（key=value格式）
Https/HTTP请求方式: post  
数据格式：form表单  
http://openapi.gateway.paasw.com/msg/balance  
请求参数  

| 参数|描述|类型|示例|是否必填
| ------------ | ------------ | ------------ | ------------ | ------------ 
|token |用户密钥通过接口获取 |String |k67jwkqzSqN6gtGHjo8KwrQrkfE4r6m4px5YEpjsWnYoBZxFwNzxQrxdQbzDSdkr |是

返回参数

|  参数 |  描述 | 类型  | 示例  |  是否必填 |
| ------------ | ------------ | ------------ | ------------ | ------------ | 
|code |响应码。0为成功，其它为错误码 |int |0 |是|
|message |响应码描述|String |请求成功 |是 
|data |成功时返回数据，json对象 |Object|如下 |是 

data字段数据格式如下

|  参数 |  描述 | 类型  | 示例  |  是否必填 |
| ------------ | ------------ | ------------ | ------------ | ------------ | 
|balance |余额 |Double |25638.23 |是|

返回报文示例
```json

{    
"code":0,    
"message":"请求成功",    
"data":{
        "balance":532
    }
 }

```
####  11: 状态(回执)推送（json格式）
Https/HTTP请求方式: 主动推送，无需请求，只需在管理端配置相应用户推送地址  
数据格式：json  
推送方式：post  

推送数据参数  

|  参数 |  描述 | 类型  | 示例  |  是否必填 |
| ------------ | ------------ | ------------ | ------------ | ------------ | 
|count |状态回执数量 |int |2 |是|
|data |返回数据，json对象 |Object|如下 |是 

data字段数据格式如下

|  参数 |  描述 | 类型  | 示例  |  是否必填 |
| ------------ | ------------ | ------------ | ------------ | ------------ | 
|batchId |发送短信时返回的批次 |Long |39036632588910887018 |是|
|mobile |手机号码 |String |15236352365 |是|
|chnRptDate |回执响应时间，格式为yyyy-MM-dd HH:mm:ss |String |2019-10-01 00:00:00 |是|
|chnRptCode |运营商返回的代码 |String |DB:0141 |是|

返回报文示例
```json

{
    "count":2,
    "data":[
            {
                "mobile" : "13900000001", 
                "chnRptDate" : "2017-01-01 00:00:00", 
                "chnRptCode" : "DB:0141",
                "batchId" : "3903663258891088785"
            },
            {
                "mobile" : "13900000001", 
                "chnRptDate" : "2017-01-01 00:00:00", 
                "chnRptCode" : "DB:0141",
                "batchId" : "39036632588910887018"
            }
        ]
}

```

####  12: 上行推送（json格式）
Https/HTTP请求方式: 主动推送，无需请求，只需在管理端配置相应用户推送地址  
数据格式：json  
推送方式：post  

推送数据参数

|  参数 |  描述 | 类型  | 示例  |  是否必填 |
| ------------ | ------------ | ------------ | ------------ | ------------ | 
|data |上行短信结果集，格式为JsonArray |Object|如下 |是 
|count |上行短信数量|int |2 |是 

data字段数据格式如下

|  参数 |  描述 | 类型  | 示例  |  是否必填 |
| ------------ | ------------ | ------------ | ------------ | ------------ | 
|mobile |手机号码 |String |15236352365 |是|
|extNo |拓展码 |String |8866 |否|
|replyDate| 上行时间，格式为yyyy-MM-dd HH:mm:ss |String |2019-10-01 00:00:00 |是|
|content | 上行回复内容,utf-8编码|String |准时参加 |是|

返回报文示例
```json

{    
"count":2,    
"data":[
        {
            "mobile":"15000000002",
            "extNo":"1234567890",
            "content":"收到短信了",
            "replyDate":"2019-01-01 08:08:08"
        },
        {
            "mobile":"15000000002",
            "extNo":"1234567890",
            "content":"收到短信了",
            "replyDate":"2019-01-01 08:08:08"
        }
    ]}

```
 

