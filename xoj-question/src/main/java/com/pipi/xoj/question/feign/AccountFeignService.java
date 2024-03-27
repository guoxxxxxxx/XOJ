package com.pipi.xoj.question.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient("xoj-account")
public interface AccountFeignService {

    @RequestMapping("/user/test")
    public String testService();
}
