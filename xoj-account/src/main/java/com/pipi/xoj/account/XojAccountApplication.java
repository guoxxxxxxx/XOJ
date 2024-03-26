package com.pipi.xoj.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 服务主要负责用户的登录鉴权，等功能。
 */
@SpringBootApplication
public class XojAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(XojAccountApplication.class, args);
    }

}
