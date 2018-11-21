package com.xiao.core.controller;

import com.xiao.core.common.ResponseBean;
import com.xiao.core.shiro.exception.UnauthorizedException;
import com.xiao.core.shiro.utils.JWTUtil;
import com.xiao.core.shiro.utils.MD5Utils;
import com.xiao.core.user.domain.User;
import com.xiao.core.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: Administrator
 * @Date: 2018/9/8 23:32
 * @Description:
 */
@RestController
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    private UserService userService;

    @Autowired
    public void setService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseBean login(@RequestParam("username") String username,
                              @RequestParam("password") String password) {
        User user = userService.findByUserName(username);
        String saltMD5 = MD5Utils.getSaltMD5(password, user.getSalt());
        if (user.getPassword().equals(saltMD5)) {
            return new ResponseBean(200, "Login success", JWTUtil.sign(username, saltMD5));
        } else {
            throw new UnauthorizedException();
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseBean logout() {
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        return new ResponseBean(200, "成功注销！", null);
    }

    @PostMapping(value = "/auth")
    public ResponseBean auth() {
        return new ResponseBean(200, "已登录！", null);
    }

    @GetMapping("/article")
    public ResponseBean article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return new ResponseBean(200, "You are already logged in", null);
        } else {
            return new ResponseBean(200, "You are guest", null);
        }
    }

    @GetMapping("/require_auth")
    @RequiresAuthentication
    public ResponseBean requireAuth() {
        return new ResponseBean(200, "You are authenticated", null);
    }

    @GetMapping("/require_role")
    @RequiresRoles("admin")
    public ResponseBean requireRole() {
        return new ResponseBean(200, "You are visiting require_role", null);
    }

    @GetMapping("/require_permission")
    @RequiresPermissions(logical = Logical.AND, value = {"view", "edit"})
    public ResponseBean requirePermission() {
        return new ResponseBean(200, "You are visiting permission require edit,view", null);
    }

    @RequestMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseBean unauthorized() {
        return new ResponseBean(401, "Unauthorized", null);
    }
}
