package com.tianxuan.makeup.repository;

import com.tianxuan.makeup.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: makeup
 * @description:
 * @author: Petrichor
 * @create: 2018-08-16 09:51
 **/
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    /**
     * 根据orderId查询订单详情信息
     */
    List<OrderDetail> findByOrderId(String orderId);
}
