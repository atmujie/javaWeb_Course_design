package com.ProClinic.controller.impl;

import com.ProClinic.controller.UsersController;
import com.ProClinic.pojo.UserAdmin;
import com.ProClinic.sevice.dao.UserBean;
import com.ProClinic.sevice.po.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserControllerImpl implements UsersController {
    private  CheckService checkService;
    private UserBean userBean;

    @Autowired
    public void setCheckService(CheckService checkService) {
        this.checkService = checkService;
    }
    @Autowired
    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    /**
     * 登录控制器
     * @param username
     * @param password
     * @return
     */
    @Override
    @PostMapping("/userLogin")
    public String userLogin(
            HttpServletRequest request,
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password) {
        UserAdmin userAdmin = null;
        if (checkService.strNotIsNull(username) && checkService.strNotIsNull(password)){
            userAdmin = userBean.loginServer(username, password);
        }
        if (userAdmin != null){
            request.setAttribute("login",userAdmin);
            request.getSession().setAttribute("login",username);
            return "redirect:/index";
        }
        else{
            request.setAttribute("login","登录失败");
            return "redirect:/login";
        }
    }

    /**
     * 注册控制器
     * @param username
     * @param password
     * @param email
     * @return 视图跳转
     */
    @Override
    @PostMapping("/register")
    public String userRegister(
            HttpServletRequest request,
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "confirmPassword") String confirmPassword,
            @RequestParam(value = "email",required = false) String email) {
        boolean flag = false;
        if (password.equals(confirmPassword)){
            if (checkService.strNotIsNull(username) && checkService.strNotIsNull(password)){
                flag = userBean.registerServer(username, password, email);
            }
        }
        if (flag) return "redirect:/login";
        else {
            request.setAttribute("register","注册失败");
            return "redirect:/sign-up";
        }
    }
}
