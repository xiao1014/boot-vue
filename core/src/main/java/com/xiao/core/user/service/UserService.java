package com.xiao.core.user.service;


import com.xiao.core.user.domain.User;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/9/7 21:28
 * @Description:
 */
public interface UserService {
    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);

    User findByUserName(String username);
}
