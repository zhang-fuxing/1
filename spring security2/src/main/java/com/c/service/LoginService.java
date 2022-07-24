package com.c.service;

import com.c.model.pojo.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author zfx
 * @date 2022-07-23 10:34
 */
public interface LoginService {
    UserDetails login(User user);
    String logout();
}
