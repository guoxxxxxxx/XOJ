package com.pipi.xoj.question.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;

/**
 * (Submit)表实体类
 *
 * @author guox
 * @since 2024-04-11 22:12:53
 */
@Data
public class Submit extends Model<Submit> implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    //主键
    private Integer id;
    //提交用户的主键
    private Integer uid;
    //时间花费, 单位ms
    private Float timeSpend;
    //内存花费,单位kb
    private Float memSpend;
    //用户所提交的代码
    private String code;
    //语言种类
    private Integer languageType;
    //提交时间
    private Date submissionTime;
    //是否删除，0: 未删除，1: 已删除
    private Integer isDelete;
    //是否通过
    private Integer isPassed;
}

