package com.pipi.xoj.account.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pipi.xoj.account.entity.User;
import com.pipi.xoj.account.service.UserService;
import com.pipi.xoj.account.vo.UserVO;
import com.pipi.xoj.common.core.response.R;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (User)表控制层
 *
 * @author guox
 * @since 2024-03-27 09:36:39
 */
@RestController
@RequestMapping("/account/user")
public class UserController{
    /**
     * 服务对象
     */
    @Autowired
    private UserService userService;

    /**
     * 通过邮箱查询用户信息
     * @param email
     * @return
     */
    @RequestMapping("/queryByEmail")
    public R<UserVO> queryByEmail(@RequestParam String email){
        User user = userService.queryByEmail(email);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return R.successResponse(userVO);
    }


    @PostMapping("/insertOne")
    public R<Integer> insertOne(@RequestBody User user){
        int i = userService.insertOne(user);
        return R.successResponse(i);
    }
}

