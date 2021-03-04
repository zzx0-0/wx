package com.example.wx.service.impl;

import com.example.wx.dao.RedirectMapper;
import com.example.wx.pojo.Redirect;
import com.example.wx.service.IRedirectService;
import com.example.wx.utils.Util;
import com.example.wx.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RedirectServiceImpl implements IRedirectService {

    @Autowired
    public RedirectMapper redirectMapper;

    @Override
    public String findRedirectUrl(String state) {
        Redirect redirect = redirectMapper.findRedirectUrl(state);
        if (redirect == null)
            throw new RuntimeException("没有该state");
        log.info("{}",redirect);
        return redirect.getUrl();
    }

    @Override
    public List<Redirect> findAll() {
        return redirectMapper.findAll();
    }

    @Override
    public Redirect findById(Integer id) {
        return redirectMapper.selectById(id);
    }

    @Override
    public ResponseVO update(Redirect redirect) {
        return Util.ff(redirectMapper.updateById(redirect));
    }

    @Override
    public ResponseVO add(Redirect redirect) {
        return Util.ff(redirectMapper.insert(redirect));
    }
}
