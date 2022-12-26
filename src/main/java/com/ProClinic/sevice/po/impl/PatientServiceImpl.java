package com.ProClinic.sevice.po.impl;

import com.ProClinic.mapping.PatientInfoMapper;
import com.ProClinic.pojo.PatientInfo;
import com.ProClinic.sevice.po.PatientService;
import com.ProClinic.sevice.po.SqlUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private PatientInfoMapper patientInfoMapper;

    @Autowired
    public void setPatientInfoMapper(SqlUtils sqlUtils) {
        SqlSession sqlSession = sqlUtils.getSqlSession();
        this.patientInfoMapper = sqlUtils.getPatientInfoMapper(sqlSession);
    }

    @Override
    // 添加一名病人的信息
    public Integer addOnePatient(PatientInfo patientInfo) {
        return patientInfoMapper.insert(patientInfo);
    }

    @Override
    // 删除一条病人的信息
    public Integer delPatientInfo(Integer id) {
        return patientInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    // 查询一名病人的信息
    public PatientInfo selectOnePatientInfo(Integer id) {
        return patientInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    // 更新一条病人的信息
    public Integer updateOnePatient(PatientInfo patientInfo) {
        return patientInfoMapper.updateByPrimaryKey(patientInfo);
    }

    @Override
    // 查询所有病人的信息
    public List<PatientInfo> selectAllPatientInfo() {
        return patientInfoMapper.selectByExample(null);
    }
}
