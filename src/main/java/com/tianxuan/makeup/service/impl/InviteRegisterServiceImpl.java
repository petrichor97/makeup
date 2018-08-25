package com.tianxuan.makeup.service.impl;

import com.tianxuan.makeup.entity.InviteRegister;
import com.tianxuan.makeup.entity.TxVipUser;
import com.tianxuan.makeup.entity.UserWelfare;
import com.tianxuan.makeup.repository.InviteRegisterRepository;
import com.tianxuan.makeup.repository.TxVipUserRepository;
import com.tianxuan.makeup.repository.UserWelfareRepository;
import com.tianxuan.makeup.service.InviteRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InviteRegisterServiceImpl implements InviteRegisterService {

    @Autowired
    private TxVipUserRepository txVipUserRepository;
    @Autowired
    private InviteRegisterRepository inviteRegisterRepository;

    @Autowired
    private UserWelfareRepository userWelfareRepository;

    @Override
    public void saveInviteRegisterTable(TxVipUser txVipUser) {

        String beInvitationCode = txVipUser.getBeInvitationCode();
//        根据邀请码查询邀请用户的信息
        TxVipUser inviteUser = txVipUserRepository.findByInvitationCode(beInvitationCode);
//        获取被邀请用户的的openid
        String beInviteUserOpenid = txVipUser.getOpenid();
        InviteRegister inviteRegister = new InviteRegister();
        inviteRegister.setInviteUserOpenid(inviteUser.getOpenid());
        inviteRegister.setBeInviteUserOpenid(beInviteUserOpenid);

        inviteRegisterRepository.save(inviteRegister);
    }

//查询用户是否为被邀请用户并且首次充值，给予邀请用户福利
@Transactional
public void inviteRegisterWelfare(String openid) {
    List<InviteRegister> inviteRegisterList = inviteRegisterRepository.findInviteRegisterByBeInviteUserOpenid(openid);
        if (inviteRegisterList!=null&&inviteRegisterList.size()>0) {

            String inviteUserOpenid = inviteRegisterList.get(0).getInviteUserOpenid();
            userWelfareRepository.saveUserWelfare(inviteUserOpenid,5);

            inviteRegisterRepository.deleteByBeInviteUserOpenid(openid);


        }
    }


}
