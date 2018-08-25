package com.tianxuan.makeup.service;

import com.tianxuan.makeup.entity.TxVipUser;

import java.math.BigDecimal;

public interface TxVipUserService {
    Long countByName(String name);

    Long countByOpenid(String openid);

    void userRegister(TxVipUser txVipUser);

    //    根据openid获取用户信息
    TxVipUser getUserInfo(String openid);
    //邀请码校验
    Long countInviteCode(String beInvitationCode);
    //修改用户余额
    void flushmoney(TxVipUser txVipUser);

}
