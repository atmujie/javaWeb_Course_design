package com.ProClinic.sevice.po;

import com.ProClinic.pojo.WaitingInfo;

import java.util.List;

public interface WaitingService {
    // 查询所有就诊信息
    List<WaitingInfo> selectWaitingAllInfo();
    // 添加一条就诊信息
    Integer addWaitingInfo(WaitingInfo waitingInfo);
    // 删除一条就诊信息
    Integer delWaitingInfo(Integer id);
}
