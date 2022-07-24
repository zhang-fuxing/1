package com.c.commone;

import com.c.model.pojo.UserDetailsImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义的校验规则
 *
 * @author zfx
 * @date 2022-07-24 10:52
 */
@Component
public class MyAuthRole {

    public boolean hasAuthority(String var) {
        // 获取到访问用户拥有的权限
        UserDetailsImpl principal =
                        (UserDetailsImpl) SecurityContextHolder.getContext()
                        .getAuthentication().getPrincipal();
        // 用户拥有的权限集合
        List<String> list = principal.getPermissions();
        // 校验用户是否拥有访问接口的权限
        return list.contains(var);
    }
}
