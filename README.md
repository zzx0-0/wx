用这个项目实现 网页用微信登录 并根据不同的参数(state)转发到不同的地址  具体由自己建数据库表redirect

在application.yml 配置自己的数据库地址

在Login.java 写上自己的appid appSecret 及url  (个人可申请微信公众平台测试号，并在微信公众平台-网页授权获取用户基本信息 配置URL)

在Constant.java写上自己在该测试公众号下的openid(根据判断这个openid进入后台的)
