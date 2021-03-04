package com.example.wx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Redirect {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @NotNull
    private String state;

    @NotNull
    private String url;

    private String remark;

}
