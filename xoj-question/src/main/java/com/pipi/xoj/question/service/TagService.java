package com.pipi.xoj.question.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pipi.xoj.question.entity.Tag;

import java.util.List;

/**
 * (Tag)表服务接口
 *
 * @author guox
 * @since 2024-04-10 14:52:00
 */
public interface TagService extends IService<Tag> {

    /**
     * 添加新的标签
     * @param tagName
     * @return 若返回值为-1则说明已经存在
     */
    int addNewTag(String tagName);

    /**
     * 获取标签列表
     * @return
     */
    List<Tag> getTagList();

}

