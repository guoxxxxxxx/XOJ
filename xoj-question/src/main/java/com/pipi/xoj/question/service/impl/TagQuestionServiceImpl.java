package com.pipi.xoj.question.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pipi.xoj.question.dao.TagQuestionDao;
import com.pipi.xoj.question.entity.TagQuestion;
import com.pipi.xoj.question.service.TagQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (TagQuestion)表服务实现类
 *
 * @author guox
 * @since 2024-04-11 14:30:15
 */
@Service("tagQuestionService")
public class TagQuestionServiceImpl extends ServiceImpl<TagQuestionDao, TagQuestion> implements TagQuestionService {

    @Autowired
    TagQuestionDao tagQuestionDao;

    @Override
    public boolean inertQuestionTags(Integer qid, Integer[] tagList) {
        int count = 0;
        for (int tag : tagList){
            TagQuestion tagQuestion = new TagQuestion();
            tagQuestion.setQid(qid);
            tagQuestion.setTid(tag);
            tagQuestionDao.insert(tagQuestion);
            count += 1;
        }
        return count == tagList.length;
    }
}

