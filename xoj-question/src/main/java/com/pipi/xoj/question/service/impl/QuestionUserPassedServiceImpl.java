package com.pipi.xoj.question.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pipi.xoj.question.dao.QuestionUserPassedDao;
import com.pipi.xoj.question.entity.QuestionUserPassed;
import com.pipi.xoj.question.service.QuestionUserPassedService;
import org.springframework.stereotype.Service;

/**
 * (QuestionUserPassed)表服务实现类
 *
 * @author guox
 * @since 2024-04-11 22:26:11
 */
@Service("questionUserPassedService")
public class QuestionUserPassedServiceImpl extends ServiceImpl<QuestionUserPassedDao, QuestionUserPassed> implements QuestionUserPassedService {

}

