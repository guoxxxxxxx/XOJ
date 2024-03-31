/**
 * @Time: 2024/3/31 14:58
 * @Author: guoxun
 * @File: UserVO
 * @Description:
 */

package com.pipi.xoj.account.vo;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Data
public class UserVO {

    //id
    @NotBlank
    private Integer id;
    //用户名
    private String username;
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
}
