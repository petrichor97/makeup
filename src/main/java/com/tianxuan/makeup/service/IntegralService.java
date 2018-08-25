package com.tianxuan.makeup.service;

import com.tianxuan.makeup.pojo.Message;

public interface IntegralService {

    //    更新用户积分
    Message saveUserIntegral(String openid, int num);
}
