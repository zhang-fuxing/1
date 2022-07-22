package com.c.controller;

import com.c.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangfx
 * @date 2022/7/20
 */
@RestController
@RequestMapping("/user")
public class AppController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/login")
    public Object test1(String username, String password) {
       return null;
    }

}
