package com.pipi.xoj.question.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pipi.xoj.question.entity.TagQuestion;

/**
 * (TagQuestion)表服务接口
 *
 * @author guox
 * @since 2024-04-11 14:30:15
 */
public interface TagQuestionService extends IService<TagQuestion> {

    boolean inertQuestionTags(Integer qid, Integer [] tagList);
}

