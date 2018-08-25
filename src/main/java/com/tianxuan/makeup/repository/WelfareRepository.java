package com.tianxuan.makeup.repository;

import com.tianxuan.makeup.entity.Welfare;
import com.tianxuan.makeup.pojo.UserWelfareIdAndWelfareName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface WelfareRepository extends JpaRepository<Welfare, String> {


    @Query( "select new com.tianxuan.makeup.pojo.UserWelfareIdAndWelfareName(u.userWelfareId,w.welfareName) from UserWelfare u ,Welfare w where u.welfareId=w.welfareId and u.openid=?1")
    List<UserWelfareIdAndWelfareName> findWelfareByOpenid(String openid);


    @Query(nativeQuery = true, value = "delete from user_welfare where user_welfare_id=?1")
    @Transactional
    @Modifying
    void delectWelfareByuserWelfareId(int userWelfareId);
}

