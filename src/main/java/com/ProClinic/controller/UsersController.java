package com.ProClinic.controller;

import javax.servlet.http.HttpServletRequest;

public interface UsersController {
    // 用户登录
    String userLogin(HttpServletRequest request, String username, String password);
    // 用户注册
    String userRegister(HttpServletRequest request,String username, String password,String confirmPassword,String email);
}
