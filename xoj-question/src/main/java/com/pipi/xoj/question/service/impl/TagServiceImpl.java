package com.pipi.xoj.question.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pipi.xoj.question.dao.TagDao;
import com.pipi.xoj.question.entity.Tag;
import com.pipi.xoj.question.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Tag)表服务实现类
 *
 * @author guox
 * @since 2024-04-10 14:52:00
 */
@Service("tagService")
public class TagServiceImpl extends ServiceImpl<TagDao, Tag> implements TagService {

    @Autowired
    TagDao tagDao;

    @Override
    public int addNewTag(String tagName) {
        QueryWrapper<Tag> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tag_name", tagName);
        // 先判断所要新增的标签数据库中是否存在
        List<Tag> tags = tagDao.selectList(queryWrapper);
        if (tags.size() == 0){
            Tag tag = new Tag();
            tag.setTagName(tagName);
            return tagDao.insert(tag);
        }
        else {
            return -1;
        }
    }

    @Override
    public List<Tag> getTagList() {
        return tagDao.selectList(new QueryWrapper<>());
    }
}

