package com.ProClinic.sevice.po;

import com.ProClinic.mapping.DoctorInfoMapper;
import com.ProClinic.mapping.PatientInfoMapper;
import com.ProClinic.mapping.UserAdminMapper;
import com.ProClinic.mapping.WaitingInfoMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public interface SqlUtils {
    /**
     * 创建SqlSession对象
     * @return sqlSession对象
     * @throws IOException
     */
    SqlSession getSqlSession();

    /**
     * 关闭sqlSession对象
     */
    void closeSqlSession(SqlSession sqlSession);

    /**
     * 得到DoctorInfoMapper
     * @return
     */
    DoctorInfoMapper getDoctorInfoMapper(SqlSession sqlSession);

    /**
     * 得到JavaWebUsers的Mapper对象
     * @return
     */
    PatientInfoMapper getPatientInfoMapper(SqlSession sqlSession);

    /**
     * 得到UserAdminMapper的Mapper对象
     * @return
     */
    UserAdminMapper getUserAdminMapper(SqlSession sqlSession);

    /**
     * 得到WaitingInfoMapper的Mapper对象
     * @return
     */
    WaitingInfoMapper getWaitingInfoMapper(SqlSession sqlSession);
}
