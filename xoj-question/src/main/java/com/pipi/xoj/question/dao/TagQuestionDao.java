package com.pipi.xoj.question.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pipi.xoj.question.entity.TagQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (TagQuestion)表数据库访问层
 *
 * @author guox
 * @since 2024-04-11 14:30:15
 */
@Mapper
public interface TagQuestionDao extends BaseMapper<TagQuestion> {

    /**
     * 通过qid查询与之对应的标签的id列表
     * @param qid
     * @return
     */
    @Select("SELECT tid FROM tag_question WHERE qid = ${qid}")
    List<Integer> selectTidListByQid(Integer qid);
}

