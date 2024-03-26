package com.pipi.xoj.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pipi.xoj.account.dao.UserDao;
import com.pipi.xoj.account.entity.User;
import com.pipi.xoj.account.service.UserService;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author guox
 * @since 2024-03-26 15:41:44
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}

