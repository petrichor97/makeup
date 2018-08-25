package com.tianxuan.makeup.service.impl;

import com.tianxuan.makeup.entity.TxVipUser;
import com.tianxuan.makeup.repository.TxVipUserRepository;
import com.tianxuan.makeup.service.TxVipUserService;
import com.tianxuan.makeup.utils.InvitationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TxVipUserServiceImpl implements TxVipUserService {
    @Autowired
    private TxVipUserRepository txVipUserRepository;

    //    openid注册校验
    public Long countByOpenid(String openid) {
        long count = txVipUserRepository.countByOpenid(openid);
        return count;
    }

//昵称注册校验
    @Override
    public Long countByName(String name) {
        Long count = txVipUserRepository.countByName(name);
        return count;
    }


    //    用户注册
    public void userRegister(TxVipUser txVipUser) {
        txVipUser.setIsNew("1");
        txVipUser.setMoney(BigDecimal.valueOf(0.00));
        txVipUser.setIntegral(0);
        txVipUser.setInvitationCode(InvitationCode.createInvitationCode(txVipUser.getOpenid()));

        txVipUserRepository.save(txVipUser);
    }


    //    根据openid获取用户信息
    public TxVipUser getUserInfo(String openid) {
        TxVipUser txVipUser = txVipUserRepository.findOne(openid);
        return txVipUser;
    }


//    邀请码校验

    public Long countInviteCode(String beInvitationCode) {
        Long countByInvitationCode = txVipUserRepository.countByInvitationCode(beInvitationCode);
        return countByInvitationCode;
    }


    //修改用户余额
    @Override
    public void flushmoney(TxVipUser txVipUser) {
          txVipUserRepository.saveAndFlush(txVipUser);
    }


}

