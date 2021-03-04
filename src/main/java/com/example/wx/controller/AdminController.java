package com.example.wx.controller;

import com.example.wx.config.Constant;
import com.example.wx.pojo.Redirect;
import com.example.wx.service.IRedirectService;
import com.example.wx.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AdminController {

    @Autowired
    private IRedirectService redirectService;

    @GetMapping("/myLogin")
    public ModelAndView admin(@RequestParam String openId,
                              HttpSession session) {
        if (!openId.equals(Constant.myOpenid))
            throw new RuntimeException("不支持该微信账号进入管理后台");
        session.setAttribute(Constant.LOGIN, "yes");
        List<Redirect> all = redirectService.findAll();
        Map map = new HashMap<>();
        map.put("all", all);
        return new ModelAndView("all",map);
    }

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam(required = false) Integer id) {
        if (id == null)
            return  new ModelAndView("redirect");

        Redirect redirect = redirectService.findById(id);
        Map map = new HashMap<>();
        map.put("redirect",redirect);
        return new ModelAndView("redirect",map);
    }

    @PostMapping("/gai")
    public ResponseVO gai(@Valid @RequestBody Redirect redirect) {
        if (redirect.getId() == null)
            return redirectService.add(redirect);
        return redirectService.update(redirect);
    }

}
