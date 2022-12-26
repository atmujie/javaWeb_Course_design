package com.ProClinic.sevice.po.impl;

import com.ProClinic.mapping.DoctorInfoMapper;
import com.ProClinic.mapping.PatientInfoMapper;
import com.ProClinic.mapping.UserAdminMapper;
import com.ProClinic.mapping.WaitingInfoMapper;
import com.ProClinic.sevice.po.SqlUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class SqlUtilsImpl implements SqlUtils {

    @Override
    public SqlSession getSqlSession() {
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        return sqlSessionFactoryBuilder.build(resourceAsStream).openSession(true);
    }

    @Override
    public void closeSqlSession(SqlSession sqlSession) {
        sqlSession.close();
    }

    @Override
    public DoctorInfoMapper getDoctorInfoMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(DoctorInfoMapper.class);
    }

    @Override
    public PatientInfoMapper getPatientInfoMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(PatientInfoMapper.class);
    }

    @Override
    public UserAdminMapper getUserAdminMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(UserAdminMapper.class);
    }

    @Override
    public WaitingInfoMapper getWaitingInfoMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(WaitingInfoMapper.class);
    }
}
