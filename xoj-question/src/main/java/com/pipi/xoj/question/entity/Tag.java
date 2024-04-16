package com.pipi.xoj.question.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;

/**
 * (Tag)表实体类
 *
 * @author guox
 * @since 2024-04-10 14:52:00
 */
@Data
public class Tag extends Model<Tag> implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    //主键自增
    @TableId(type = IdType.AUTO)
    private Integer id;
    //标签名
    private String tagName;
}

