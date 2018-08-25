package com.tianxuan.makeup.repository;

import com.tianxuan.makeup.entity.ChargeMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderMoneyRepository extends JpaRepository<ChargeMoney, String> {

//    @Query(nativeQuery = true, value = "select * from charge_money where order_id =?1")
//
//    ChargeMoney findByOrderId(String orderId);
}
