package com.c.dao;

import com.c.model.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author zfx
 * @date 2022-07-23 9:39
 */
@Repository
public class UserDao {

    public User getUserByUserName(String username) {
        return new User(username,username,"1");
    }
}
