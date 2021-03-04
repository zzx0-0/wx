package com.example.wx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.wx.pojo.Redirect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RedirectMapper extends BaseMapper<Redirect> {

    @Select("select * from redirect where state = #{state}")
    Redirect findRedirectUrl(String state);

    @Select("select * from redirect")
    List<Redirect> findAll();

}
