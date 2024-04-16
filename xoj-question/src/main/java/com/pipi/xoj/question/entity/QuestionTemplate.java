package com.pipi.xoj.question.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;

/**
 * (QuestionTemplate)表实体类
 *
 * @author guox
 * @since 2024-04-09 18:29:16
 */
@Data
public class QuestionTemplate extends Model<QuestionTemplate> implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    //主键id
    @TableId(type = IdType.AUTO)
    private Integer id;
    //question的主键
    private Integer qid;
    //语言种类
    private Integer languageType;
    //时间限制，单位毫秒
    private Float timeLimit;
    //内存限制
    private Float memLimit;
    //是否删除，0: 未删除，1: 已删除
    private Integer isDelete;
    //模板代码前缀
    private String templatePref;
    //模板代码中间部分，即用户可见区
    private String templateMid;
    //模板代码后缀
    private String templateRear;
}

