package com.pipi.xoj.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pipi.xoj.account.dao.UserDao;
import com.pipi.xoj.account.entity.User;
import com.pipi.xoj.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author guox
 * @since 2024-03-27 09:36:51
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    UserDao userDao;


    @Override
    public User queryByEmail(String email) {
        return  userDao.selectOne(new QueryWrapper<User>().eq("email", email));
    }

    @Override
    public int insertOne(User user) {
        return userDao.insert(user);
    }

    @Override
    public boolean isRegisterByEmail(String email) {
        User user = userDao.selectOne(new QueryWrapper<User>().eq("email", email));
        return user != null;
    }
}

