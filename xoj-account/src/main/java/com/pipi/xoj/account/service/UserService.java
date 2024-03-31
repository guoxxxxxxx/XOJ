package com.pipi.xoj.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pipi.xoj.account.entity.User;

/**
 * (User)表服务接口
 *
 * @author guox
 * @since 2024-03-27 09:36:50
 */
public interface UserService extends IService<User> {

    /**
     * 通过邮箱查询用户信息
     * @param email
     * @return
     */
    User queryByEmail(String email);

    /**
     * 插入一个新用户
     * @param user
     * @return
     */
    int insertOne(User user);
}

