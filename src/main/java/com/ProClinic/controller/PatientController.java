package com.ProClinic.controller;

import com.ProClinic.pojo.PatientInfo;
import javax.servlet.http.HttpServletRequest;

public interface PatientController {
    // 查询所有病人信息
    String selectAllPatientInfo(HttpServletRequest request);
    // 添加新的病人信息
    String addPatientInfo(PatientInfo patientInfo, HttpServletRequest request);
    // 删除一条病人信息
    String delPatient(Integer id, HttpServletRequest request);
    // 显示编辑病人信息页面
    String editPatient(HttpServletRequest request);
    // 更新病人信息
    String updatePatientInfo(PatientInfo patientInfo,HttpServletRequest request);
}
