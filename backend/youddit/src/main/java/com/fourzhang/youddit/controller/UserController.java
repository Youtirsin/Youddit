package com.fourzhang.youddit.controller;

import com.fourzhang.youddit.data.Result;
import com.fourzhang.youddit.data.ResultCode;
import com.fourzhang.youddit.data.ResultTool;
import com.fourzhang.youddit.entity.User;
import com.fourzhang.youddit.request.SignUpRequest;
import com.fourzhang.youddit.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/api/user/signup")
    public Result<Integer> signUp(@RequestBody SignUpRequest request) {
        try {
            User user = new User();
            user.setUsername(request.getUsername());
            user.setPassword(request.getPassword());
            user.setEmail(request.getEmail());
            user.setPhone(request.getPhone());
            userService.signUp(user);
            return ResultTool.success();
        } catch (Exception e) {
            return ResultTool.fail(ResultCode.USER_ACCOUNT_ALREADY_EXIST);
        }
    }
}