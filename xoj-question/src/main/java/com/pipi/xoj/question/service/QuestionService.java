package com.pipi.xoj.question.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pipi.xoj.question.entity.Question;

/**
 * (Question)表服务接口
 *
 * @author guox
 * @since 2024-03-27 10:05:33
 */
public interface QuestionService extends IService<Question> {

    /**
     * 插入一个对象
     * @param question
     * @return
     */
    int insertOne(Question question);

    /**
     * 通过id查询题目详细信息
     * @param id
     * @return
     */
    Question queryById(Integer id);

}

