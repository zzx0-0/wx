package com.example.wx.pojo;

import lombok.Data;

@Data
public class Wx2 {

    private String access_token;

    private Integer expires_in;   // 单位：秒

    private String refresh_token;

    private String openid;

    private String scope;  // 用户授权的作用域，使用逗号（,）分隔

}
