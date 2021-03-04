package com.example.wx.enums;

import lombok.Getter;

@Getter
public enum ResponseEnum {

    ERROR(-1, "错误"),

    SUCCESS(0, "成功"),

            ;

    Integer code;

    String desc;

    ResponseEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
