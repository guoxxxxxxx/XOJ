/**
 * @Time: 2024/3/30 15:45
 * @Author: guoxun
 * @File: AuthCodeDTO
 * @Description:
 */

package com.pipi.xoj.authority.dto;

import com.pipi.xoj.authority.exception.groups.LoginGroup;
import com.pipi.xoj.authority.exception.groups.RegisterGroup;
import com.pipi.xoj.authority.exception.groups.RetrieveGroup;
import com.pipi.xoj.authority.exception.groups.SendCodeGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthCodeDTO {
    // 目标邮箱
    @Email(groups = {RegisterGroup.class, LoginGroup.class, RetrieveGroup.class, SendCodeGroup.class})
    @NotBlank(groups = {RegisterGroup.class, LoginGroup.class, RetrieveGroup.class, SendCodeGroup.class})
    private String email;

    // 验证码
    @NotBlank(groups = {RetrieveGroup.class, RegisterGroup.class})
    private String code;

    @NotBlank(groups = {RegisterGroup.class, LoginGroup.class})
    @Min(value = 8, groups = {RegisterGroup.class, LoginGroup.class})
    private String password;
}
