package com.pipi.xoj.authority;

import com.pipi.xoj.common.core.response.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient("xoj-account")
public interface AccountFeignService {

    @PostMapping("/insertOne")
    public R<Integer> insertOne(@RequestBody User user);
}
