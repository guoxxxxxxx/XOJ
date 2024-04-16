package com.pipi.xoj.question.controller;



import com.pipi.xoj.common.core.response.R;
import com.pipi.xoj.question.entity.Tag;
import com.pipi.xoj.question.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Tag)表控制层
 *
 * @author guox
 * @since 2024-04-10 14:52:00
 */
@RestController
@RequestMapping("/question/tag")
public class TagController{
    /**
     * 服务对象
     */
    @Autowired
    private TagService tagService;

    /**
     * 向数据库中新增标签
     * @param tagName
     * @return
     */
    @GetMapping("/addNewTag")
    public R<Void> addNewTag(@RequestParam String tagName){
        int i = tagService.addNewTag(tagName);
        if (i == 1){
            return R.successResponse("新增标签成功");
        } else if (i == -1) {
            return R.errorResponse("该标签在数据库中已经存在");
        }
        else
            return R.errorResponse("新增失败");
    }

    /**
     * 获取所有标签列表
     * @return
     */
    @GetMapping("/getTagList")
    public R<List<Tag>> getTagList(){
        List<Tag> tagList = tagService.getTagList();
        return R.successResponse(tagList);
    }

}

