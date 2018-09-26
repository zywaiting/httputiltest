# httputiltest 源码：https://github.com/zywaiting/httputil

项目引入包
````
<dependency>
    <groupId>xin.zhuyao.httputil</groupId>
    <artifactId>httputil</artifactId>
    <version>0.0.1</version>
</dependency>

````


##get/gets(http/https)

get/gets(String url) 请求路径无参数   

get/gets(String url, String encoding) 请求带编码要求

get/gets(String url, Map<String, String> args) 请求有参数（如：http://baidu.com?x=1&y=2)(map 就是(map.put("x","1");map.put("y","2")))

get/gets(String url,String encoding, Map<String, String> args) 请求带编码要求有参数

get/gets(String url, KeyValue... args)(KeyValue 简单工具对象，用来存放键值对。用法(KeyValue[] keyValues = new KeyValue[]{new KeyValue("x","1")}))

get/gets(String url, String encoding, KeyValue... args)请求带编码要求有参数

##getHeader/getsHeader(http/https)

getHeader/getsHeader(String url, Map<String, String> headers)请求路径无参数有header (比如阿里的 headers.put("Authorization", "APPCODE " + appcode);就可以map.put("Authorization","APPCODE "+appcode))

getHeader/getsHeader(String url, KeyValue... headers) 请求路径无参数有header

getHeader/getsHeader(String url, String encoding, KeyValue... headers)请求带编码要求有header

getHeader/getsHeader(String url, Map<String, String> headers, Map<String, String> args)请求路径有header有参数((headers):map1.put("x","1");(args):map2.put("y","2"))

getHeader/getsHeader(String url,String encoding, Map<String, String> headers, Map<String, String> args)请求带编码要求有header有参数

getHeader/getsHeader(String url,String encoding, KeyValue[] headers, KeyValue... args)请求路径有header有参数

getHeader/getsHeader(String url, String encoding, KeyValue[] headers, KeyValue... args)请求带编码要求有header有参数


##post/posts同上


##postHeader/postsHeader同上


##postContent/postsContent同上

postContent/postsContent(String url, String content)路径加内容


post/posts(String url, HttpEntity httpEntity)路径加内容
