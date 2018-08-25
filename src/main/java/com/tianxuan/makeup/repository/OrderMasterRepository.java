package com.tianxuan.makeup.repository;

import com.tianxuan.makeup.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: makeup
 * @description: 订单dao
 * @author: Petrichor
 * @create: 2018-08-16 09:49
 **/
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    /**
     * 根据买家openid查询订单分页列表
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
