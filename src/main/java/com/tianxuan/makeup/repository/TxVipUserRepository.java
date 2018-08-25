package com.tianxuan.makeup.repository;

import com.tianxuan.makeup.entity.TxVipUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.math.BigDecimal;

public interface TxVipUserRepository extends JpaRepository<TxVipUser, String> {
    Long countByName(String name);

    Long countByOpenid(String openid);

    Long countByInvitationCode(String invitationCode);

//    @Query(nativeQuery = true, value = "select u from TxVipUser u where u.beInvitationCode=?1")
//    @Transactional
//    根据邀请码查询邀请用户讯息
    TxVipUser findByInvitationCode(String beInvitationCode);

    @Transactional
    @Modifying
    @Query("update TxVipUser u set u.money = ?1 where u.openid = ?2")
    void modifyMpneyByopenid(BigDecimal money, String openid);


}

