package com.pipi.xoj.account.controller;

import com.pipi.xoj.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (User)表控制层
 *
 * @author guox
 * @since 2024-03-26 15:41:43
 */
@RestController
@RequestMapping("user")
public class UserController{
    /**
     * 服务对象
     */
    @Autowired
    private UserService userService;
}

