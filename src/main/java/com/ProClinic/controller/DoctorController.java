package com.ProClinic.controller;

import com.ProClinic.pojo.DoctorInfo;
import javax.servlet.http.HttpServletRequest;

public interface DoctorController {
    // 查询所有的医生信息
    String selectAllDoctorInfo(HttpServletRequest request);
    // 查询某一个医生的信息
    DoctorInfo selectOneDoctorInfo(Integer id);
    // 添加医生信息
    String addDoctor(DoctorInfo doctorInfo,HttpServletRequest request);
    // 删除一条医生信息
    String delDoctorInfo(Integer id,HttpServletRequest request);
    // 更新医生信息
    String updateDoctorInfo(HttpServletRequest request);
    // 提交更新
    String submitUpdate(DoctorInfo doctorInfo,HttpServletRequest request);
}
