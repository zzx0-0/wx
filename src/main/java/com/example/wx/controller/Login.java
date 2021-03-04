package com.example.wx.controller;

import com.alibaba.fastjson.JSON;
import com.example.wx.config.Constant;
import com.example.wx.pojo.Wx2;
import com.example.wx.pojo.Wx4;
import com.example.wx.service.IRedirectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class Login {

    @Autowired
    private IRedirectService redirectService;

    private static final String mpAppId = "";

    private static final String mpAppSecret = "";

    private static final String url = "http://" + "";  // 后面填微信公众平台-网页授权获取用户基本信息 填写的URL

    @GetMapping("/login/{state}")
    public String authorize(@PathVariable String state) {
        log.info("进入login, state={}",state);
        String redirectUrl = url + "/userInfo";

        String responseUrl ="https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + mpAppId +
                "&redirect_uri=" + URLDecoder.decode(redirectUrl) +
                "&response_type=code" +
                "&scope=" + Constant.USER_INFO +
                "&state=" + state +
                "#wechat_redirect";

        log.info("redirectUrl:   {}", redirectUrl);
        log.info("responseUrl:   {}", responseUrl);
        return "redirect:" + responseUrl;
    }

    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String state) {
        log.info("进入userInfo...");
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + mpAppId +
                "&secret=" + mpAppSecret +
                "&code=" + code +
                "&grant_type=authorization_code";

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        Wx2 wx2 = JSON.parseObject(response, Wx2.class);
        assert wx2 != null;
        log.info("{}",wx2);

        // 刷新access_token（如果需要）
        /*
            由于access_token拥有较短的有效期，当access_token超时后，可以使用refresh_token进行刷新，
            refresh_token有效期为30天，当refresh_token失效之后，需要用户重新授权。

        String url3 = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=" + mpAppId +
                "&grant_type=refresh_token" +
                "&refresh_token=" + wx2.getRefresh_token();

        response = restTemplate.getForObject(url3, String.class);
        wx2 = JSON.parseObject(response, Wx2.class);
        */

        // 需scope为 snsapi_userinfo
        String newUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + wx2.getAccess_token() +
                "&openid=" + wx2.getOpenid() +
                "&lang=zh_CN";
        String res = restTemplate.getForObject(newUrl, String.class);
        assert res != null;
        res = new String(res.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        Wx4 wx4 = JSON.parseObject(res, Wx4.class);
        log.info("{}",wx4);

        String finalUrl;
        if (state.equals("admin")) {
            finalUrl = "/myLogin?openId=" + wx2.getOpenid();
        } else {
            finalUrl = redirectService.findRedirectUrl(state) + "?openId=" + wx2.getOpenid();
        }

        log.info("最终redirect： {}", finalUrl);
        return "redirect:" + finalUrl;
    }

}
