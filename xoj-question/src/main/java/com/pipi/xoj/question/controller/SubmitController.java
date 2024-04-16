package com.pipi.xoj.question.controller;



import com.pipi.xoj.question.service.SubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (Submit)表控制层
 *
 * @author guox
 * @since 2024-04-11 22:12:53
 */
@RestController
@RequestMapping("submit")
public class SubmitController{
    /**
     * 服务对象
     */
    @Autowired
    private SubmitService submitService;
}

