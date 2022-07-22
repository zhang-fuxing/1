package com.c.dao;

import com.c.model.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author zhangfx
 * @date 2022/7/20
 */
@Repository
public class UserDao {
    public User getUser(String username){
        return new User(username,"123456","1");
    }
}
