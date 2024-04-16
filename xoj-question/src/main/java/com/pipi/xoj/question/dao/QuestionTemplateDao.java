package com.pipi.xoj.question.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pipi.xoj.question.entity.QuestionTemplate;
import org.apache.ibatis.annotations.Mapper;

/**
 * (QuestionTemplate)表数据库访问层
 *
 * @author guox
 * @since 2024-04-09 18:14:54
 */
@Mapper
public interface QuestionTemplateDao extends BaseMapper<QuestionTemplate> {

}

