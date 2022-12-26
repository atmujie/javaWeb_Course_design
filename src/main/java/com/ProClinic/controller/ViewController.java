package com.ProClinic.controller;

import javax.servlet.http.HttpServletRequest;

// 视图初始转发控制
public interface ViewController {
    // 登录视图转发控制
    String loginView(HttpServletRequest request);
    // 注册视图转发控制
    String registerView();
    // 首页转发控制
    String indexView();

    // 查询医生信息页面
    String doctorsView();
    // 增加医生信息页面
    String addDoctorView();
    // 编辑医生信息页面
    String editDoctor(Integer id,HttpServletRequest request);

    // 查询病人信息页面
    String patientView();
    // 添加病人信息
    String addPatientView();
    // 编辑病人信息
    String updatePatientView(Integer id,HttpServletRequest request);
}
