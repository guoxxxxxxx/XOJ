package com.pipi.xoj.question.controller;



import com.pipi.xoj.question.service.QuestionTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (QuestionTemplate)表控制层
 *
 * @author guox
 * @since 2024-04-09 18:14:54
 */
@RestController
@RequestMapping("/question/template")
public class QuestionTemplateController{
    /**
     * 服务对象
     */
    @Autowired
    private QuestionTemplateService questionTemplateService;
}

