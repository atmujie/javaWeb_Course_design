package com.ProClinic.sevice.dao.impl;

import com.ProClinic.mapping.UserAdminMapper;
import com.ProClinic.pojo.UserAdmin;
import com.ProClinic.sevice.dao.UserBean;
import com.ProClinic.sevice.po.CheckService;
import com.ProClinic.sevice.po.EncodeTools;
import com.ProClinic.sevice.po.SqlUtils;
import com.ProClinic.sevice.po.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBeanImpl implements UserBean {
    private CheckService checkService;
    private UserAdminMapper userAdminMapper;
    private EncodeTools encodeTools;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setCheckService(CheckService checkService) {
        this.checkService = checkService;
    }

    @Autowired
    public void setEncodeTools(EncodeTools encodeTools) {
        this.encodeTools = encodeTools;
    }

    @Autowired
    public void setSqlUtils(SqlUtils sqlUtils) {
        SqlSession sqlSession = sqlUtils.getSqlSession();
        this.userAdminMapper = sqlUtils.getUserAdminMapper(sqlSession);
    }

    /**
     * 登录服务组件
     * @param username
     * @param password
     * @return
     */
    @Override
    public UserAdmin loginServer(String username, String password) {
        String md5Password = encodeTools.md5Encode(password);
        UserAdmin userAdmin = userAdminMapper.selectByPrimaryKey(username);
        if (userAdmin.getPassword().equals(md5Password)) return userAdmin;
        else return null;
    }

    /**
     * 注册服务组件
     * @param username
     * @param password
     * @param email
     * @return 成功为true,失败为false
     */
    @Override
    public boolean registerServer(String username, String password, String email) {
        if (!checkService.userExists(username)){
            String md5Password = encodeTools.md5Encode(password);
            int flag = userService.insertUserAdmin(username, md5Password, email);
            return flag == 1;
        }else return false;
    }
}
