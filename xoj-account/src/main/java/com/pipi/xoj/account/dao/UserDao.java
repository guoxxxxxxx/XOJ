package com.pipi.xoj.account.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pipi.xoj.account.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * (User)表数据库访问层
 *
 * @author guox
 * @since 2024-03-26 15:41:43
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}

