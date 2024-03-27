package com.pipi.xoj.question;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient  // 开启nacos
@EnableFeignClients(basePackages = "com.pipi.xoj.question.feign")     // 开启远程调用功能
public class XojQuestionApplication {

    public static void main(String[] args) {
        SpringApplication.run(XojQuestionApplication.class, args);
    }

}
