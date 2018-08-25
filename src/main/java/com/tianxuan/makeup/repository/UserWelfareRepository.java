package com.tianxuan.makeup.repository;

import com.tianxuan.makeup.entity.UserWelfare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserWelfareRepository extends JpaRepository<UserWelfare,String> {
    @Transactional
    @Modifying
    @Query(value = "insert into user_welfare(openid,welfare_id) values(?1,?2)",nativeQuery = true)
    void saveUserWelfare(String openid,int welfareId);
}
