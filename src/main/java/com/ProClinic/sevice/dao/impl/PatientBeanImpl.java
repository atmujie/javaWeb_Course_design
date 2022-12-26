package com.ProClinic.sevice.dao.impl;

import com.ProClinic.pojo.PatientInfo;
import com.ProClinic.pojo.WaitingInfo;
import com.ProClinic.sevice.dao.PatientBean;
import com.ProClinic.sevice.dao.PatientDetailsPojo;
import com.ProClinic.sevice.po.DoctorService;
import com.ProClinic.sevice.po.EncodeTools;
import com.ProClinic.sevice.po.PatientService;
import com.ProClinic.sevice.po.WaitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientBeanImpl implements PatientBean {
    private PatientService patientService;
    private WaitingService waitingService;
    private DoctorService doctorService;
    private EncodeTools encodeTools;

    @Autowired
    public void setEncodeTools(EncodeTools encodeTools) {
        this.encodeTools = encodeTools;
    }

    @Autowired
    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Autowired
    public void setWaitingService(WaitingService waitingService) {
        this.waitingService = waitingService;
    }

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }


    @Override
    // 按需查询病人详情表项
    public List<PatientDetailsPojo> selectPatientDetails() {
        List<PatientInfo> patientInfos = patientService.selectAllPatientInfo();
        List<WaitingInfo> waitingInfos = waitingService.selectWaitingAllInfo();
        List<PatientDetailsPojo> patientDetailsPojoRes = new ArrayList<PatientDetailsPojo>();
        for (PatientInfo p: patientInfos) {
            PatientDetailsPojo patientDetailsPojo = new PatientDetailsPojo();
            patientDetailsPojo.setPatientId(p.getPatientId());
            patientDetailsPojo.setPatientName(p.getPatientName());
            patientDetailsPojo.setPatientAge(p.getPatientAge());
            patientDetailsPojo.setPatientPhone(p.getPatientPhone());
            for (WaitingInfo w: waitingInfos) {
                if (p.getPatientId().equals(w.getWaitingPatientId())){
                    patientDetailsPojo.setWaitingStatus(w.getWaitingStatus());
                    patientDetailsPojo.setWaitingUpdate(
                            encodeTools.dateDecode(w.getWaitingUpdate())
                    );
                    patientDetailsPojo.setWaitingDate(
                            encodeTools.dateDecode(w.getWaitingDate())
                    );
                    if (w.getWaitingDoctorId() != null){
                        patientDetailsPojo.setWaitingDoctorId(w.getWaitingDoctorId());
                        patientDetailsPojo.setDoctorName(
                                doctorService.selectOneDoctorInfo(w.getWaitingDoctorId()
                                ).getDoctorName());
                    }
                    break;
                }
            }
            patientDetailsPojoRes.add(patientDetailsPojo);
        }
        return patientDetailsPojoRes;
    }

    @Override
    public Integer addPatientBean(PatientInfo patientInfo) {
        Integer integer = patientService.addOnePatient(patientInfo);
        Integer waiting = null;
        if (integer == 1){
            WaitingInfo waitingInfo = new WaitingInfo();
            waitingInfo.setWaitingPatientId(patientInfo.getPatientId());
            waiting = waitingService.addWaitingInfo(waitingInfo);
        }
        return waiting;
    }

    @Override
    // 删除病人信息
    public Integer delPatientBean(Integer id) {
        Integer integer = waitingService.delWaitingInfo(id);
        Integer res = null;
        if (integer == 1) res = patientService.delPatientInfo(id);
        return res;
    }

    @Override
    public PatientInfo selectOnePatientBean(Integer id) {
        PatientInfo patientInfo = patientService.selectOnePatientInfo(id);
        patientInfo.setStrPatientBirth(
                encodeTools.dateDiagonalLineDecode(patientInfo.getPatientBirth())
        );
        return patientInfo;
    }
}
