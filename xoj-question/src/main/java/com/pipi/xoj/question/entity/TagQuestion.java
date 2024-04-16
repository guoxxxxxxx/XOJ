package com.pipi.xoj.question.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.lang.reflect.Type;

import lombok.Data;

/**
 * (TagQuestion)表实体类
 *
 * @author guox
 * @since 2024-04-11 14:30:15
 */
@Data
public class TagQuestion extends Model<TagQuestion> implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    //主键自增
    @TableId(type = IdType.AUTO)
    private Integer id;
    //question的主键
    private Integer qid;
    //tag表的主键
    private Integer tid;
}

