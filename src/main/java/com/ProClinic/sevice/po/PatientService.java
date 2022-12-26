package com.ProClinic.sevice.po;

import java.util.List;
import com.ProClinic.pojo.PatientInfo;

public interface PatientService {
    // 查询所有病人的信息
    List<PatientInfo> selectAllPatientInfo();
    // 添加一名病人的信息
    Integer addOnePatient(PatientInfo patientInfo);
    // 删除一条病人的信息
    Integer delPatientInfo(Integer id);
    // 查询一名病人的信息
    PatientInfo selectOnePatientInfo(Integer id);
    // 更新一条病人的信息
    Integer updateOnePatient(PatientInfo patientInfo);
}
