/**
 * @Time: 2024/3/31 12:26
 * @Author: guoxun
 * @File: AuthExceptionControllerAdvice
 * @Description:
 */

package com.pipi.xoj.account.exception;

import com.pipi.xoj.common.core.response.R;
import com.pipi.xoj.common.core.response.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.pipi.xoj.account.controller")
@Slf4j
public class AccountExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e){
        log.error("数据校验出现异常, 异常信息: {}; 异常类型: {}", e.getMessage(), e.getClass());
        return R.errorResponse(ResponseStatus.DATA_VERIFICATION_FAILS);
    }
}
