package com.ProClinic.sevice.po;

public interface UserService {
    // 增加用户
    int insertUserAdmin(String username, String md5Password,String email);
}
