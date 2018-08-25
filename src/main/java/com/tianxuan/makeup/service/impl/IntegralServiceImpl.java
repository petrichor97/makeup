package com.tianxuan.makeup.service.impl;

import com.tianxuan.makeup.entity.TxVipUser;
import com.tianxuan.makeup.pojo.Message;
import com.tianxuan.makeup.repository.TxVipUserRepository;
import com.tianxuan.makeup.service.IntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class IntegralServiceImpl implements IntegralService {
    @Autowired
    private TxVipUserRepository txVipUserRepository;


    @Override
//    @Transactional
    public Message saveUserIntegral(String openid, int num) {
        Message message = new Message();
        TxVipUser txVipUser = txVipUserRepository.findOne(openid);
        int integral = txVipUser.getIntegral();
        int newIntegral = integral - num;
        if (newIntegral < 0) {
            message.setMessage("积分不足");
            return message;
        }
        txVipUser.setIntegral(newIntegral);
        txVipUserRepository.saveAndFlush(txVipUser);
        message.setMessage("兑换成功");
        return message;
    }
}
