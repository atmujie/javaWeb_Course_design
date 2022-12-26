package com.ProClinic.sevice.dao;

import com.ProClinic.pojo.PatientInfo;

import java.util.List;

public interface PatientBean {
    // 查询数据库，返回病人的详情表
    List<PatientDetailsPojo> selectPatientDetails();
    // 增加一条病人信息
    Integer addPatientBean(PatientInfo patientInfo);
    // 删除一条病人信息
    Integer delPatientBean(Integer id);
    // 返回一条病人信息
    PatientInfo selectOnePatientBean(Integer id);
}
