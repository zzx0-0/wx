package com.example.wx.pojo;

import lombok.Data;

@Data
public class Wx4 {

    private String openid;

    private String nickname;

    private Integer sex;   //值为1时是男性，值为2时是女性，值为0时是未知

    private String province;

    private String city;

    private String country;

    private String headimgurl;

    private String privilege;

    private String unionid;

}
