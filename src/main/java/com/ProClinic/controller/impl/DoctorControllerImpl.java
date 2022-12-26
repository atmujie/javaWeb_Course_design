package com.ProClinic.controller.impl;

import com.ProClinic.controller.DoctorController;
import com.ProClinic.pojo.DoctorInfo;
import com.ProClinic.sevice.po.CheckService;
import com.ProClinic.sevice.po.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorControllerImpl implements DoctorController {
    private DoctorService doctorService;
    private CheckService checkService;

    @Autowired
    public void setCheckService(CheckService checkService) {
        this.checkService = checkService;
    }

    @Autowired
    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Override
    @GetMapping("/selectAllInfo")
    // 查询全部的医生信息
    public String selectAllDoctorInfo(HttpServletRequest request) {
        List<DoctorInfo> doctorInfos = doctorService.selectAllDoctorInfo();
        request.setAttribute("doctors",doctorInfos);
        return "doctors";
    }

    @Override
    @GetMapping("/selectId/{id}")
    // 查询某一个医生的信息
    public DoctorInfo selectOneDoctorInfo(@PathVariable Integer id) {
        return doctorService.selectOneDoctorInfo(id);
    }

    @Override
    @PostMapping("/addDoctor")
    // 添加一条医生信息
    public String addDoctor(DoctorInfo doctorInfo,HttpServletRequest request) {
        if(checkService.strNotIsNull(doctorInfo.getDoctorName())){
            Integer integer = doctorService.addDoctorInfo(doctorInfo);
            request.getSession().setAttribute("AddDocResults",integer);
        }else request.getSession().setAttribute("AddDocResults",false);
        return "redirect:/add-doctor";
    }

    @Override
    @GetMapping("/delDoctorInfo/{id}")
    // 删除一条医生信息
    public String delDoctorInfo(@PathVariable Integer id, HttpServletRequest request) {
        if (id != null){
            Integer integer = doctorService.delDoctorInfo(id);
            request.getSession().setAttribute("delDocResults",integer);
        }
        else request.getSession().setAttribute("delDocResults",false);
        return "redirect:/doctors";
    }

    @Override
    @GetMapping("/editDoctor")
    public String updateDoctorInfo(HttpServletRequest request) {
        Integer id = (Integer) request.getAttribute("id");
        if (id != null){
            DoctorInfo doctorInfo = doctorService.selectOneDoctorInfo(id);
            request.setAttribute("doctorInfo",doctorInfo);
        }else request.setAttribute("doctorInfo",false);
        return "edit-doctor";
    }

    @Override
    @PostMapping("/submitUpdate")
    public String submitUpdate(DoctorInfo doctorInfo, HttpServletRequest request) {
        if(checkService.strNotIsNull(doctorInfo.getDoctorName())){
            Integer integer = doctorService.updateDoctorInfo(doctorInfo);
            request.getSession().setAttribute("delDocResults",integer);
        }else request.getSession().setAttribute("delDocResults",false);
        return "redirect:/doctors";
    }
}
