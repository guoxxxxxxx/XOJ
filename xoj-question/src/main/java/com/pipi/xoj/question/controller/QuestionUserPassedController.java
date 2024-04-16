package com.pipi.xoj.question.controller;



import com.pipi.xoj.question.service.QuestionUserPassedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (QuestionUserPassed)表控制层
 *
 * @author guox
 * @since 2024-04-11 22:26:11
 */
@RestController
@RequestMapping("questionUserPassed")
public class QuestionUserPassedController{
    /**
     * 服务对象
     */
    @Autowired
    private QuestionUserPassedService questionUserPassedService;
}

