package com.pipi.xoj.question.controller;



import com.pipi.xoj.question.service.TagQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (TagQuestion)表控制层
 *
 * @author guox
 * @since 2024-04-11 14:30:15
 */
@RestController
@RequestMapping("tagQuestion")
public class TagQuestionController{
    /**
     * 服务对象
     */
    @Autowired
    private TagQuestionService tagQuestionService;



}

