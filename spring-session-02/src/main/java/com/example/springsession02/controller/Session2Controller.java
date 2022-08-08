package com.example.springsession02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author zfx
 * @date 2022-08-08 20:17
 */
@RestController
public class Session2Controller {

    @GetMapping("/2/get")
    public String get(HttpSession session) {
        return (String) session.getAttribute("iSession");
    }

    @GetMapping("/2/set")
    public String set(HttpSession session) {
        session.setAttribute("iSession","1364858653@163.com");
        return "set success 1";
    }
}
