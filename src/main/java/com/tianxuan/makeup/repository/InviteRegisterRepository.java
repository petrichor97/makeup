package com.tianxuan.makeup.repository;

import com.tianxuan.makeup.entity.InviteRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface InviteRegisterRepository extends JpaRepository<InviteRegister,String>{
    Long countByBeInviteUserOpenid(String openid);
    @Transactional
    @Modifying
    @Query(value = "delete from invite_register where be_invite_user_openid=?1",nativeQuery = true)
    void deleteByBeInviteUserOpenid(String beInviteUserOpenid);

    List<InviteRegister> findInviteRegisterByBeInviteUserOpenid(String openid);
}
