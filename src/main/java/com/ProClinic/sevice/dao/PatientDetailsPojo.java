package com.ProClinic.sevice.dao;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class PatientDetailsPojo {
    private Integer patientId; // 病人id
    private String patientName; // 病人姓名
    private Integer patientAge; // 病人年龄
    private String patientPhone; // 病人电话
    private Integer waitingDoctorId; // 医生id
    private String doctorName; // 主治医生
    private Integer waitingStatus; // 就诊状态
    private String waitingUpdate; // 更新时间
    private String waitingDate; // 就诊日期

    @Override
    public String toString() {
        return "PatientBeanImpl{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", patientAge=" + patientAge +
                ", patientPhone='" + patientPhone + '\'' +
                ", waitingDoctorId=" + waitingDoctorId +
                ", doctorName='" + doctorName + '\'' +
                ", waitingStatus=" + waitingStatus +
                ", waitingUpdate=" + waitingUpdate +
                ", waitingDate=" + waitingDate +
                '}';
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public void setWaitingDoctorId(Integer waitingDoctorId) {
        this.waitingDoctorId = waitingDoctorId;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setWaitingStatus(Integer waitingStatus) {
        this.waitingStatus = waitingStatus;
    }

    public void setWaitingUpdate(String waitingUpdate) {
        this.waitingUpdate = waitingUpdate;
    }

    public void setWaitingDate(String waitingDate) {
        this.waitingDate = waitingDate;
    }
}
