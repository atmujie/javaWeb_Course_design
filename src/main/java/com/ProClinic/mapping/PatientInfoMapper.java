package com.ProClinic.mapping;

import com.ProClinic.pojo.PatientInfo;
import com.ProClinic.pojo.PatientInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PatientInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient_info
     *
     * @mbggenerated Wed Nov 09 23:05:11 CST 2022
     */
    int countByExample(PatientInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient_info
     *
     * @mbggenerated Wed Nov 09 23:05:11 CST 2022
     */
    int deleteByExample(PatientInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient_info
     *
     * @mbggenerated Wed Nov 09 23:05:11 CST 2022
     */
    int deleteByPrimaryKey(Integer patientId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient_info
     *
     * @mbggenerated Wed Nov 09 23:05:11 CST 2022
     */
    int insert(PatientInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient_info
     *
     * @mbggenerated Wed Nov 09 23:05:11 CST 2022
     */
    int insertSelective(PatientInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient_info
     *
     * @mbggenerated Wed Nov 09 23:05:11 CST 2022
     */
    List<PatientInfo> selectByExampleWithBLOBs(PatientInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient_info
     *
     * @mbggenerated Wed Nov 09 23:05:11 CST 2022
     */
    List<PatientInfo> selectByExample(PatientInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient_info
     *
     * @mbggenerated Wed Nov 09 23:05:11 CST 2022
     */
    PatientInfo selectByPrimaryKey(Integer patientId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient_info
     *
     * @mbggenerated Wed Nov 09 23:05:11 CST 2022
     */
    int updateByExampleSelective(@Param("record") PatientInfo record, @Param("example") PatientInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient_info
     *
     * @mbggenerated Wed Nov 09 23:05:11 CST 2022
     */
    int updateByExampleWithBLOBs(@Param("record") PatientInfo record, @Param("example") PatientInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient_info
     *
     * @mbggenerated Wed Nov 09 23:05:11 CST 2022
     */
    int updateByExample(@Param("record") PatientInfo record, @Param("example") PatientInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient_info
     *
     * @mbggenerated Wed Nov 09 23:05:11 CST 2022
     */
    int updateByPrimaryKeySelective(PatientInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient_info
     *
     * @mbggenerated Wed Nov 09 23:05:11 CST 2022
     */
    int updateByPrimaryKeyWithBLOBs(PatientInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient_info
     *
     * @mbggenerated Wed Nov 09 23:05:11 CST 2022
     */
    int updateByPrimaryKey(PatientInfo record);
}