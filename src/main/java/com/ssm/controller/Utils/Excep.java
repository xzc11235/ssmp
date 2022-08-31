package com.ssm.controller.Utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice

public class Excep {
    @ExceptionHandler
    public R doex(Exception exception){
        exception.printStackTrace();
        return new R(false,"错误");
    }

}
