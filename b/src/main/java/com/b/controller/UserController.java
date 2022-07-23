package com.b.controller;

import com.b.pojo.User;
import com.b.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zfx
 * @date 2022-07-23 9:39
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String login(String username, String password) {
        UserDetails login = loginService.login(new User(username, password));
        return login == null ? "error" : String.valueOf(login);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
