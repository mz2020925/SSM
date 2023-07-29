package com.itheima.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)  // 说明这个方法处理哪种异常
    public Result doException(Exception e){
        System.out.println("这样写会把所有的异常拦截过来");
        return new Result(500, null);
    }
}
