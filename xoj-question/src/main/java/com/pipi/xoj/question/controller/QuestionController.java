package com.pipi.xoj.question.controller;



import com.pipi.xoj.question.feign.AccountFeignService;
import com.pipi.xoj.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (Question)表控制层
 *
 * @author guox
 * @since 2024-03-27 10:05:30
 */
@RestController
@RequestMapping("question")
public class QuestionController{
    /**
     * 服务对象
     */
    @Autowired
    private QuestionService questionService;

    @Autowired
    private AccountFeignService accountFeignService;

    @RequestMapping("/testAccountFeign")
    public String testFeign(){
        return accountFeignService.testService();
    }
}

