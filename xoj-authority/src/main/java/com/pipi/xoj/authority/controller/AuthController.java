/**
 * @Time: 2024/3/30 16:11
 * @Author: guoxun
 * @File: SendAuthCodeController
 * @Description:
 */

package com.pipi.xoj.authority.controller;

import com.pipi.xoj.authority.dto.AuthCodeDTO;
import com.pipi.xoj.authority.exception.groups.RegisterGroup;
import com.pipi.xoj.authority.exception.groups.SendCodeGroup;
import com.pipi.xoj.authority.utils.EmailMessage;
import com.pipi.xoj.authority.utils.RandomCodeUtils;
import com.pipi.xoj.common.core.constant.AuthServerConstant;
import com.pipi.xoj.common.core.response.R;
import com.pipi.xoj.common.core.response.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * 发送验证码服务
     * @param authCodeDTO
     * @return
     */
    @PostMapping("/sendCode")
    public R<Void> sendCode(@Validated(value = {SendCodeGroup.class}) @RequestBody AuthCodeDTO authCodeDTO){

        // 从redis中读取验证码，防止同一邮箱在60s内反复发送验证码
        String redisCode = redisTemplate.opsForValue().get(AuthServerConstant.AUTH_CODE_CACHE_PREFIX + authCodeDTO.getEmail());
        if (redisCode != null){
            long timestamp = Long.parseLong(redisCode.split("_")[1]);
            if (System.currentTimeMillis() - timestamp < 60 * 1000){
                return R.errorResponse(ResponseStatus.AUTH_CODE_EXCEPTION);
            }
        }

        // 获取验证码
        String code = RandomCodeUtils.getRandomCode() + "_" + System.currentTimeMillis();
        // 验证码的再次校验 key-email, value-code 并设置过期时间
        redisTemplate.opsForValue().set(AuthServerConstant.AUTH_CODE_CACHE_PREFIX + authCodeDTO.getEmail(), code,
                EmailMessage.EMAIL_BASE_MSG.getTime(), TimeUnit.MINUTES);

//        MailUtils.sendMessage(code, authCodeDTO.getTargetEmail(), EmailMessage.EMAIL_BASE_MSG.getSubject(),
//                EmailMessage.EMAIL_BASE_MSG.getText(), EmailMessage.EMAIL_BASE_MSG.getTime());
        return R.successResponse();
    }


    @PostMapping("/register")
    public R register(@Validated(value = {RegisterGroup.class}) @RequestBody AuthCodeDTO authCodeDTO){

    }

    @PostMapping("/login")
    public R login(){
        return R.successResponse();
    }
}
