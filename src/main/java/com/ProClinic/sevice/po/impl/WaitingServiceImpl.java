package com.ProClinic.sevice.po.impl;

import com.ProClinic.mapping.WaitingInfoMapper;
import com.ProClinic.pojo.WaitingInfo;
import com.ProClinic.pojo.WaitingInfoExample;
import com.ProClinic.sevice.po.SqlUtils;
import com.ProClinic.sevice.po.WaitingService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaitingServiceImpl implements WaitingService {
    private WaitingInfoMapper waitingInfoMapper;

    @Autowired
    public void setWaitingInfoMapper(SqlUtils sqlUtils) {
        SqlSession sqlSession = sqlUtils.getSqlSession();
        this.waitingInfoMapper = sqlUtils.getWaitingInfoMapper(sqlSession);
    }


    @Override
    // 查询所有就诊信息
    public List<WaitingInfo> selectWaitingAllInfo() {
        return waitingInfoMapper.selectByExample(null);
    }

    @Override
    // 删除一条就诊信息
    public Integer delWaitingInfo(Integer id) {
        WaitingInfoExample waitingInfoExample = new WaitingInfoExample();
        waitingInfoExample.createCriteria().andWaitingPatientIdEqualTo(id);
        return waitingInfoMapper.deleteByExample(waitingInfoExample);
    }

    @Override
    // 添加一条就诊信息
    public Integer addWaitingInfo(WaitingInfo waitingInfo) {
        return waitingInfoMapper.insert(waitingInfo);
    }
}
