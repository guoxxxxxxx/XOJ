package com.pipi.xoj.account.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;

/**
 * (User)表实体类
 *
 * @author guox
 * @since 2024-03-27 09:36:50
 */
@Data
public class User extends Model<User> implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    //id
    private Integer id;
    //用户名
    private String username;
    //密码
    private String password;
    //昵称
    private String nickname;
    //邮箱
    private String email;
    //学号
    private String studentId;
    //所属院系
    private Integer faculty;
    //所属班级
    private Integer className;
    //性别
    private Integer gender;
    //权限, xxx格式
    private Integer authority;
    //角色, 0:管理员; 1:学生; 2:教师; 3:游客
    private Integer role;
    //出生年月日
    private Date birthday;
    //是否删除，0: 未删除，1: 已删除
    private Integer isDelete;
}

