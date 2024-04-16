package com.pipi.xoj.question.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pipi.xoj.question.dao.QuestionDao;
import com.pipi.xoj.question.dao.TagDao;
import com.pipi.xoj.question.dao.TagQuestionDao;
import com.pipi.xoj.question.entity.Question;
import com.pipi.xoj.question.entity.TagQuestion;
import com.pipi.xoj.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Question)表服务实现类
 *
 * @author guox
 * @since 2024-03-27 10:05:33
 */
@Service("questionService")
public class QuestionServiceImpl extends ServiceImpl<QuestionDao, Question> implements QuestionService {

    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private TagQuestionDao tagQuestionDao;
    @Autowired
    private TagDao tagDao;

    @Override
    public int insertOne(Question question) {
        return questionDao.insert(question);
    }

    @Override
    public Question queryById(Integer id) {
        QueryWrapper<Question> questionQueryWrapper = new QueryWrapper<>();
        questionQueryWrapper.eq("id", id);
        Question question = questionDao.selectOne(questionQueryWrapper);
        List<Integer> tidList = tagQuestionDao.selectTidListByQid(question.getId());
        List<String> list = tagDao.selectTagsByIds(tidList);
        question.setTagNameList(list);
        return question;
    }
}

