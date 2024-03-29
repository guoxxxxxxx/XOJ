/**
 * @Time: 2024/3/29 18:26
 * @Author: guoxun
 * @File: ExceptionControllerAdvice
 * @Description: 集中处理所有异常
 */

package com.pipi.xoj.account.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackages = "com.pipi.xoj.account.controller")
public class ExceptionControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public void handleValidationException(Exception e){
        log.error("Data check is not passed!{}.\n Exception Type: {}", e.getMessage(), e.getClass());
    }
}
