package com.xiao.bootvue.service.impl;

import com.xiao.bootvue.mapper.RoleMapper;
import com.xiao.bootvue.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Administrator
 * @Date: 2018/9/9 19:24
 * @Description:
 */
@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
}
