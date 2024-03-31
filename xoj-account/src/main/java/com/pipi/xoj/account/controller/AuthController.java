/**
 * @Time: 2024/3/30 16:11
 * @Author: guoxun
 * @File: SendAuthCodeController
 * @Description:
 */

package com.pipi.xoj.account.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.pipi.xoj.account.dto.AuthCodeDTO;
import com.pipi.xoj.account.entity.User;
import com.pipi.xoj.account.exception.groups.LoginGroup;
import com.pipi.xoj.account.exception.groups.RegisterGroup;
import com.pipi.xoj.account.exception.groups.RetrieveGroup;
import com.pipi.xoj.account.exception.groups.SendCodeGroup;
import com.pipi.xoj.account.service.UserService;
import com.pipi.xoj.account.utils.*;
import com.pipi.xoj.account.vo.UserVO;
import com.pipi.xoj.common.core.constant.AuthServerConstant;
import com.pipi.xoj.common.core.response.R;
import com.pipi.xoj.common.core.response.ResponseStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/account/auth")
public class AuthController {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    UserService userService;

    /**
     * 发送验证码服务
     * @return
     */
    @PostMapping("/sendCode")
    public R<Void> sendCode(@Validated(SendCodeGroup.class) @RequestBody AuthCodeDTO authCodeDTO){

        // 判断当前邮箱是否已经被注册 注册逻辑
        if (userService.isRegisterByEmail(authCodeDTO.getEmail()) && authCodeDTO.getMode() == 0)
            return R.errorResponse(ResponseStatus.EMAIL_IS_ALREADY_REGISTER);
        // 找回密码逻辑
        if (!userService.isRegisterByEmail(authCodeDTO.getEmail()) && authCodeDTO.getMode() == 1)
            return R.errorResponse(ResponseStatus.EMAIL_NOT_REGISTER);

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

        MailUtils.sendMessage(code.split("_")[0], authCodeDTO.getEmail(), EmailMessage.EMAIL_BASE_MSG.getSubject(),
                EmailMessage.EMAIL_BASE_MSG.getText(), EmailMessage.EMAIL_BASE_MSG.getTime());
        return R.successResponse();
    }


    /**
     * 注册服务
     * @param authCodeDTO
     * @return
     */
    @PostMapping("/register")
    public R register(@Validated(RegisterGroup.class) @RequestBody AuthCodeDTO authCodeDTO){

        // 判断当前邮箱是否已经被注册
        if (userService.isRegisterByEmail(authCodeDTO.getEmail()))
            return R.errorResponse(ResponseStatus.EMAIL_IS_ALREADY_REGISTER);
        // 从redis中读取验证码
        String code = redisTemplate.opsForValue().get(AuthServerConstant.AUTH_CODE_CACHE_PREFIX + authCodeDTO.getEmail());
        if (code == null){
            return R.errorResponse(ResponseStatus.VALIDA_CODE_EXPIRED);
        } else if (code.split("_")[0].equals(authCodeDTO.getCode()) &&
        Long.parseLong(code.split("_")[1]) - System.currentTimeMillis() <= 10 * 6000) {
            User user = new User();
            BeanUtils.copyProperties(authCodeDTO, user);
            String uuid = UUIDUtils.getUUID();
            String md5 = MD5Utils.getMD5(authCodeDTO.getPassword() + uuid);
            user.setPassword(md5);
            user.setSalt(uuid);
            int i = userService.insertOne(user);
            if (i > 0){
                redisTemplate.delete(AuthServerConstant.AUTH_CODE_CACHE_PREFIX+authCodeDTO.getEmail());
                return R.successResponse(ResponseStatus.SUCCESS);
            }
            else
                return R.errorResponse(ResponseStatus.FAIL);
        }
        else
            return R.errorResponse(ResponseStatus.VALIDA_CODE_FAIL);
    }


    /**
     * 登录服务
     * @param authCodeDTO
     * @return
     */
    @PostMapping("/login")
    public R<UserVO> login(@Validated(LoginGroup.class) @RequestBody AuthCodeDTO authCodeDTO){
        // 判断当前邮箱是否已经被注册
        if (!userService.isRegisterByEmail(authCodeDTO.getEmail()))
            return R.errorResponse(ResponseStatus.EMAIL_NOT_REGISTER);
        // 登录逻辑
        User user = userService.queryByEmail(authCodeDTO.getEmail());
        // 计算加盐后的加密密码
        String md5 = MD5Utils.getMD5(authCodeDTO.getPassword() + user.getSalt());
        // 创建VO对象
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        if (md5.equals(user.getPassword())){
            StpUtil.login(user.getId());
            return R.successResponse(userVO);
        }
        else {
            return R.errorResponse(ResponseStatus.PASSWORD_FAIL);
        }
    }

    @PostMapping("/retrieve")
    public R retrieve(@Validated(RetrieveGroup.class) @RequestBody AuthCodeDTO authCodeDTO){
        // 判断邮箱是否已经被注册
        if (!userService.isRegisterByEmail(authCodeDTO.getEmail()))
            return R.errorResponse(ResponseStatus.EMAIL_NOT_REGISTER);
        // 从redis中读取验证码
        String code = redisTemplate.opsForValue().get(AuthServerConstant.AUTH_CODE_CACHE_PREFIX + authCodeDTO.getEmail());
        if (code == null){
            return R.errorResponse(ResponseStatus.VALIDA_CODE_EXPIRED);
        } else if (code.split("_")[0].equals(authCodeDTO.getCode()) &&
                Long.parseLong(code.split("_")[1]) - System.currentTimeMillis() <= 10 * 6000) {
            User user = userService.queryByEmail(authCodeDTO.getEmail());
            String md5 = MD5Utils.getMD5(authCodeDTO.getPassword() + user.getSalt());
            user.setPassword(md5);
            boolean status = userService.updateById(user);
            if (status){
                redisTemplate.delete(AuthServerConstant.AUTH_CODE_CACHE_PREFIX+authCodeDTO.getEmail());
                return R.successResponse(ResponseStatus.SUCCESS);
            }
            else
                return R.errorResponse(ResponseStatus.FAIL);
        }
        else
            return R.errorResponse(ResponseStatus.VALIDA_CODE_FAIL);
    }
}
