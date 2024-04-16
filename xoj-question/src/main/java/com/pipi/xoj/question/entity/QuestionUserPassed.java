package com.pipi.xoj.question.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;

/**
 * (QuestionUserPassed)表实体类
 *
 * @author guox
 * @since 2024-04-11 22:26:11
 */
@Data
public class QuestionUserPassed extends Model<QuestionUserPassed> implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    //主键
    @TableId(type = IdType.AUTO)
    private Integer id;
    //用户主键
    private Integer uid;
    //问题主键
    private Integer qid;
}

