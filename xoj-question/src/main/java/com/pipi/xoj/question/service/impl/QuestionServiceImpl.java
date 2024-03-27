package com.pipi.xoj.question.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pipi.xoj.question.dao.QuestionDao;
import com.pipi.xoj.question.entity.Question;
import com.pipi.xoj.question.service.QuestionService;
import org.springframework.stereotype.Service;

/**
 * (Question)表服务实现类
 *
 * @author guox
 * @since 2024-03-27 10:05:33
 */
@Service("questionService")
public class QuestionServiceImpl extends ServiceImpl<QuestionDao, Question> implements QuestionService {

}

