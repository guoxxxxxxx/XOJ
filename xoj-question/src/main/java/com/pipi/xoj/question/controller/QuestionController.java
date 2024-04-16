package com.pipi.xoj.question.controller;



import com.pipi.xoj.common.core.response.R;
import com.pipi.xoj.question.entity.Question;
import com.pipi.xoj.question.entity.QuestionTemplate;
import com.pipi.xoj.question.feign.AccountFeignService;
import com.pipi.xoj.question.service.QuestionService;
import com.pipi.xoj.question.service.QuestionTemplateService;
import com.pipi.xoj.question.service.TagQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Question)表控制层
 *
 * @author guox
 * @since 2024-03-27 10:05:30
 */
@RestController
@RequestMapping("/question")
public class QuestionController{
    /**
     * 服务对象
     */
    @Autowired
    private QuestionService questionService;
    @Autowired
    private TagQuestionService tagQuestionService;
    @Autowired
    private QuestionTemplateService questionTemplateService;

    @Autowired
    private AccountFeignService accountFeignService;

    /**
     * 新建一个题目
     * @param question
     * @return
     */
    @PostMapping("/insertOne")
    public R<Void> insertOne(@RequestBody Question question){
        // 把题目信息插入到数据库中
        int i = questionService.insertOne(question);
        // 将题目模板更新到数据库中
        boolean b1 = questionTemplateService.insertTemplates(question.getId(), question.getTemplateList());
        // 将标签更新到数据库中
        boolean b = tagQuestionService.inertQuestionTags(question.getId(), question.getTagList());
        if (i > 0 && b && b1){
            return R.successResponse();
        }
        return R.errorResponse("新建题目错误");
    }


    @GetMapping("/queryById")
    public R<Question> queryById(@RequestParam Integer id){
        Question question = questionService.queryById(id);
        return R.successResponse(question);
    }

    @GetMapping("/test")
    public R<Void> test(){
        return R.successResponse("测试成功！");
    }
}

