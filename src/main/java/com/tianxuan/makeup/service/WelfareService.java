package com.tianxuan.makeup.service;

import com.tianxuan.makeup.pojo.UserWelfareIdAndWelfareName;

import java.util.List;


public interface WelfareService {


    List<UserWelfareIdAndWelfareName> findWelfareByOpenid(String openid);

    void delectWelfareByuserWelfareId(int userWelfareId);
}
