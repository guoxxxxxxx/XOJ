package com.pipi.xoj.question.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pipi.xoj.question.entity.QuestionUserPassed;
import org.apache.ibatis.annotations.Mapper;

/**
 * (QuestionUserPassed)表数据库访问层
 *
 * @author guox
 * @since 2024-04-11 22:26:11
 */
@Mapper
public interface QuestionUserPassedDao extends BaseMapper<QuestionUserPassed> {

}

