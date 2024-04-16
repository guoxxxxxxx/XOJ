package com.pipi.xoj.question.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pipi.xoj.question.entity.Submit;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Submit)表数据库访问层
 *
 * @author guox
 * @since 2024-04-11 22:12:53
 */
@Mapper
public interface SubmitDao extends BaseMapper<Submit> {

}

