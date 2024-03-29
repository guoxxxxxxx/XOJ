package com.pipi.xoj.account.controller;



import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.pipi.xoj.account.entity.User;
import com.pipi.xoj.account.service.UserService;
import com.pipi.xoj.common.valid.group.AddGroup;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * (User)表控制层
 *
 * @author guox
 * @since 2024-03-27 09:36:39
 */
@RefreshScope   // 动态刷新nacos配置
@RestController
@RequestMapping("/user")
public class UserController{
    /**
     * 服务对象
     */
    @Autowired
    private UserService userService;

    @Value("${msg:default}")
    private String msg;

    @RequestMapping("/test")
    public String testService(){
        return msg + " t1";
    }

    @RequestMapping("/userInfo")
    public User userInfo(){
        User user = new User();
        user.setUsername("name");
        return user;
    }

    @RequestMapping("/update")
    public String update(@Validated({AddGroup.class}) @RequestBody User user, BindingResult result){
        if (result.hasErrors()){
            return "has error";
        }
        else {
            return "success";
        }
    }
}

