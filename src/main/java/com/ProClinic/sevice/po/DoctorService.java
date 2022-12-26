package com.ProClinic.sevice.po;

import com.ProClinic.pojo.DoctorInfo;
import java.util.List;

public interface DoctorService {
    // 查询所有医生的信息
    List<DoctorInfo> selectAllDoctorInfo();
    // 查询某一个医生的信息
    DoctorInfo selectOneDoctorInfo(Integer id);
    // 添加一条医生信息
    Integer addDoctorInfo(DoctorInfo doctorInfo);
    // 删除一条医生信息
    Integer delDoctorInfo(Integer id);
    // 更新一条医生信息
    Integer updateDoctorInfo(DoctorInfo doctorInfo);
}
