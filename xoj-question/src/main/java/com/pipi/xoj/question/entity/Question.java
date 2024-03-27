package com.pipi.xoj.question.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;

/**
 * (Question)表实体类
 *
 * @author guox
 * @since 2024-03-27 10:05:32
 */
@Data
public class Question extends Model<Question> implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    //主键id
    private Integer id;
    //题目标题
    private String title;
    //题目详细描述
    private String description;
    //当前题目所支持的语言,采用如下形式进行存储 "0,1,2"
    private String languageTypeList;
    //题目难度等级，分1-10档，1最简单，10最难
    private Integer level;
    //示例, 采用JSON格式进行存储
    private String example;
    //提示内容
    private String tips;
    //进阶内容
    private String advance;
    //提交次数
    private Integer submitCount;
    //通过次数
    private Integer passCount;
    //测试用例，采用JSON格式进行存储
    private String testCase;
    //验证用例，采用JSON格式进行存储
    private String valCase;
    //是否删除，0: 未删除，1: 已删除
    private Integer isDelete;
}

