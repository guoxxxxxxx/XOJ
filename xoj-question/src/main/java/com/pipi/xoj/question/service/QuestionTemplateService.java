package com.pipi.xoj.question.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pipi.xoj.question.entity.QuestionTemplate;

import java.util.List;

/**
 * (QuestionTemplate)表服务接口
 *
 * @author guox
 * @since 2024-04-09 18:14:54
 */
public interface QuestionTemplateService extends IService<QuestionTemplate> {

    /**
     * 插入多个个代码模板
     * @param
     * @return
     */
    boolean insertTemplates(Integer qid, List<QuestionTemplate> templateList);

}

