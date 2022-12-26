package com.ProClinic.sevice.po.impl;

import com.ProClinic.mapping.DoctorInfoMapper;
import com.ProClinic.pojo.DoctorInfo;
import com.ProClinic.sevice.po.DoctorService;
import com.ProClinic.sevice.po.SqlUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService  {

    private DoctorInfoMapper doctorInfoMapper;
    @Autowired
    public void setSqlUtils(SqlUtils sqlUtils) {
        SqlSession sqlSession = sqlUtils.getSqlSession();
        this.doctorInfoMapper = sqlUtils.getDoctorInfoMapper(sqlSession);
    }

    @Override
    public List<DoctorInfo> selectAllDoctorInfo() {
        return doctorInfoMapper.selectByExample(null);
    }

    @Override
    public DoctorInfo selectOneDoctorInfo(Integer id) {
        return doctorInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer addDoctorInfo(DoctorInfo doctorInfo) {
        return doctorInfoMapper.insert(doctorInfo);
    }

    @Override
    public Integer updateDoctorInfo(DoctorInfo doctorInfo) {
        return doctorInfoMapper.updateByPrimaryKey(doctorInfo);
    }

    @Override
    public Integer delDoctorInfo(Integer id) {
        return doctorInfoMapper.deleteByPrimaryKey(id);
    }
}
