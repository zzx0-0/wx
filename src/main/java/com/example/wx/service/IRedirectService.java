package com.example.wx.service;

import com.example.wx.pojo.Redirect;
import com.example.wx.vo.ResponseVO;

import java.util.List;

public interface IRedirectService {

    String findRedirectUrl(String state);

    Redirect findById(Integer id);

    List<Redirect> findAll();

    ResponseVO update(Redirect redirect);

    ResponseVO add(Redirect redirect);

}
