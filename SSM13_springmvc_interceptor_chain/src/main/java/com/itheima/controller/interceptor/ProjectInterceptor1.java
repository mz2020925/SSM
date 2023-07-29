package com.itheima.controller.interceptor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ProjectInterceptor1 implements HandlerInterceptor {
    @Override  // 这个方法在控制器中的方法被执行前，执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器1的preHandle方法被执行");
        return true;  // return true表示继续后面操作，return false表示终止操作，后面的操作不做了--这是拦截器典型的常用的应用
    }

    @Override  // 这个方法在控制器中的方法被执行后，执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器1的postHandle方法被执行");
    }

    @Override  // 这个方法相当于finally中的方法
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截器1的afterCompletion方法被执行");
    }
}
