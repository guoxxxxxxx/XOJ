package com.pipi.xoj.question.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pipi.xoj.question.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Tag)表数据库访问层
 *
 * @author guox
 * @since 2024-04-10 14:52:00
 */
@Mapper
public interface TagDao extends BaseMapper<Tag> {

    /**
     * 根据多个id查询对应的标签
     * @param ids
     * @return
     */
    @Select("<script>"
            + "SELECT tag_name FROM tag WHERE id IN "
            + "<foreach item='item' collection='ids' open='(' separator=',' close=')'>"
            + "#{item}"
            + "</foreach>"
            + "</script>")
    List<String> selectTagsByIds(List<Integer> ids);
}

