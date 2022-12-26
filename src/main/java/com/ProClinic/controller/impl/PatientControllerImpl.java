package com.ProClinic.controller.impl;

import com.ProClinic.controller.PatientController;
import com.ProClinic.pojo.PatientInfo;
import com.ProClinic.sevice.dao.PatientBean;
import com.ProClinic.sevice.dao.PatientDetailsPojo;
import com.ProClinic.sevice.po.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/patient")
public class PatientControllerImpl implements PatientController {
    private PatientBean patientBean;
    private PatientService patientService;

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @Autowired
    public void setPatientBean(PatientBean patientBean) {
        this.patientBean = patientBean;
    }

    @Override
    @GetMapping("/selectAllPatientInfo")
    // 查询全部的病人信息
    public String selectAllPatientInfo(HttpServletRequest request) {
        List<PatientDetailsPojo> patientDetailsPojoRes = patientBean.selectPatientDetails();
        request.setAttribute("patients",patientDetailsPojoRes);
        return "patients";
    }

    @Override
    @PostMapping("/addPat")
    public String addPatientInfo(PatientInfo patientInfo, HttpServletRequest request) {
        Integer integer = patientBean.addPatientBean(patientInfo);
        if (integer == 1) request.getSession().setAttribute("AddPatResults",integer);
        else request.getSession().setAttribute("AddPatResults",false);
        return "redirect:/add-patient";
    }

    @Override
    @GetMapping("/delPatient/{id}")
    public String delPatient(@PathVariable Integer id, HttpServletRequest request) {
        if (id != null){
            Integer integer = patientBean.delPatientBean(id);
            request.getSession().setAttribute("delPatResults",integer);
        }
        else request.getSession().setAttribute("delPatResults",false);
        return "redirect:/patients";
    }

    @Override
    @GetMapping("/editPatient")
    public String editPatient(HttpServletRequest request) {
        Integer id = (Integer) request.getAttribute("id");
        if (id != null){
            PatientInfo patientInfo = patientBean.selectOnePatientBean(id);
            request.setAttribute("patientInfo",patientInfo);
        }else request.setAttribute("patientInfo",false);
        return "edit-patient";
    }

    @Override
    @PostMapping("/updatePat")
    public String updatePatientInfo(PatientInfo patientInfo,HttpServletRequest request) {
        Integer integer = patientService.updateOnePatient(patientInfo);
        request.getSession().setAttribute("delPatResults",integer);
        return "redirect:/patients";
    }
}
