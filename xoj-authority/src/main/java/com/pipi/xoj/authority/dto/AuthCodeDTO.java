/**
 * @Time: 2024/3/30 15:45
 * @Author: guoxun
 * @File: AuthCodeDTO
 * @Description:
 */

package com.pipi.xoj.authority.dto;

import lombok.Data;

@Data
public class AuthCodeDTO {
    // 目标邮箱
    private String targetEmail;
    // 验证码
    private String code;
}
