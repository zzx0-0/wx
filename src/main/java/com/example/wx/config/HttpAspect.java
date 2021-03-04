package com.example.wx.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class HttpAspect {

    //指定切入点表达式
    @Pointcut("execution(public * com.example.wx.controller.AdminController.*(..))" +
    "&& !execution(public * com.example.wx.controller.AdminController.admin(..))")
    public void pointcut() {}

    // JoinPoint  连接点
    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String lo = (String) request.getSession().getAttribute(Constant.LOGIN);
        if (lo == null)
            throw new RuntimeException("未登录");
    }

}
