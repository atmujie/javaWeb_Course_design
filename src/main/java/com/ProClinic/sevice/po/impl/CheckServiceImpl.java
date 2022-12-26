package com.ProClinic.sevice.po.impl;

import com.ProClinic.mapping.UserAdminMapper;
import com.ProClinic.sevice.po.CheckService;
import com.ProClinic.sevice.po.SqlUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CheckServiceImpl implements CheckService {
    private UserAdminMapper userAdminMapper;

    @Autowired
    public void setSqlUtils(SqlUtils sqlUtils) {
        SqlSession sqlSession = sqlUtils.getSqlSession();
        this.userAdminMapper = sqlUtils.getUserAdminMapper(sqlSession);
    }

    /**
     * 检查用户是否存在 存在则返回true
     * @param username
     * @return
     */
    @Override
    public boolean userExists(String username) {
        return userAdminMapper.selectByPrimaryKey(username) != null;
    }

    @Override
    public boolean strIsNull(String str) {
        return str.equals("");
    }

    @Override
    public boolean strNotIsNull(String str) {
        return !str.equals("");
    }
}
