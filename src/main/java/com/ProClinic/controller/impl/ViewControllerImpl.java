package com.ProClinic.controller.impl;

import com.ProClinic.controller.ViewController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class ViewControllerImpl implements ViewController {
    @Override
    @GetMapping("/login")
    // 登录视图转发控制
    public String loginView(HttpServletRequest request) {
        return "login";
    }

    @Override
    @GetMapping("/sign-up")
    // 注册视图转发控制
    public String registerView() {
        return "sign-up";
    }

    @Override
    @GetMapping("/index")
    // 首页视图转发器
    public String indexView() {
        return "index";
    }

    @Override
    @GetMapping("/doctors")
    public String doctorsView() {
        return "forward:/doctor/selectAllInfo";
    }

    @Override
    @GetMapping("/add-doctor")
    public String addDoctorView() {
        return "add-doctor";
    }

    @Override
    @GetMapping("/edit-doctor")
    public String editDoctor(Integer id,HttpServletRequest request) {
        request.setAttribute("id",id);
        return "forward:/doctor/editDoctor";
    }

    @Override
    @GetMapping("/patients")
    public String patientView() {
        return "forward:/patient/selectAllPatientInfo";
    }

    @Override
    @GetMapping("/add-patient")
    public String addPatientView() {
        return "add-patient";
    }

    @Override
    @GetMapping("/edit-patient")
    public String updatePatientView(Integer id,HttpServletRequest request) {
        request.setAttribute("id",id);
        return "forward:/patient/editPatient";
    }
}
