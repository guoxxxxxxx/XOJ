package com.pipi.xoj.question.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pipi.xoj.question.entity.Question;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Question)表数据库访问层
 *
 * @author guox
 * @since 2024-03-27 10:05:32
 */
@Mapper
public interface QuestionDao extends BaseMapper<Question> {

}

