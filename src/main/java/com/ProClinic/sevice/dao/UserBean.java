package com.ProClinic.sevice.dao;

import com.ProClinic.pojo.UserAdmin;

public interface UserBean {
    // 登录
    UserAdmin loginServer(String username, String password);
    // 注册
    boolean registerServer(String username, String password,String email);
}
