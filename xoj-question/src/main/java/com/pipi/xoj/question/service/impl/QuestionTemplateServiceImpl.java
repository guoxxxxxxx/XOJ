package com.pipi.xoj.question.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pipi.xoj.question.dao.QuestionTemplateDao;
import com.pipi.xoj.question.entity.Question;
import com.pipi.xoj.question.entity.QuestionTemplate;
import com.pipi.xoj.question.service.QuestionTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (QuestionTemplate)表服务实现类
 *
 * @author guox
 * @since 2024-04-09 18:14:54
 */
@Service("questionTemplateService")
public class QuestionTemplateServiceImpl extends ServiceImpl<QuestionTemplateDao, QuestionTemplate> implements QuestionTemplateService {

    @Autowired
    QuestionTemplateDao questionTemplateDao;

    @Override
    public boolean insertTemplates(Integer qid, List<QuestionTemplate> templateList) {
        int count = 0;
        for (QuestionTemplate template : templateList){
            if (template.getLanguageType() == -1){
                count ++;
            } else {
                template.setQid(qid);
                questionTemplateDao.insert(template);
                count ++;
            }
        }
        return count == templateList.size();
    }
}

