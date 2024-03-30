package com.pipi.xoj.authority.utils;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EmailMessage {

    EMAIL_BASE_MSG("【验证码】🚀XCode Online Judge ", "尊敬的用户，您本次所需的验证码为:", "10");

    private String subject;
    private String text;
    private String time;
}
