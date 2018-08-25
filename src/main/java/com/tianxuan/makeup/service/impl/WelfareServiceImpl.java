package com.tianxuan.makeup.service.impl;

import com.tianxuan.makeup.pojo.UserWelfareIdAndWelfareName;
import com.tianxuan.makeup.repository.WelfareRepository;
import com.tianxuan.makeup.service.WelfareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WelfareServiceImpl implements WelfareService {
    @Autowired
   private WelfareRepository welfareRepository;


    @Override
    public List<UserWelfareIdAndWelfareName> findWelfareByOpenid(String openid) {

        List<UserWelfareIdAndWelfareName> welfareNameByOpenid = welfareRepository.findWelfareByOpenid(openid);
        return welfareNameByOpenid;
    }

    @Override
    public void delectWelfareByuserWelfareId(int userWelfareId) {
        welfareRepository.delectWelfareByuserWelfareId(userWelfareId);
    }



}
