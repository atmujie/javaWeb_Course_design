package com.ProClinic.sevice.po.impl;

import com.ProClinic.mapping.UserAdminMapper;
import com.ProClinic.pojo.UserAdmin;
import com.ProClinic.sevice.po.SqlUtils;
import com.ProClinic.sevice.po.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserAdminMapper userAdminMapper;

    @Autowired
    public void setSqlUtils(SqlUtils sqlUtils) {
        SqlSession sqlSession = sqlUtils.getSqlSession();
        this.userAdminMapper = sqlUtils.getUserAdminMapper(sqlSession);
    }

    @Override
    public int insertUserAdmin(String username, String md5Password, String email) {
        UserAdmin userAdmin = new UserAdmin();
        userAdmin.setUsername(username);
        userAdmin.setPassword(md5Password);
        userAdmin.setEmail(email);
        return userAdminMapper.insert(userAdmin);
    }
}
