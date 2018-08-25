package com.tianxuan.makeup.service;

import com.tianxuan.makeup.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @program: makeup
 * @description:
 * @author: Petrichor
 * @create: 2018-08-16 10:00
 **/
public interface OrderService {

    /** 创建订单 */
    OrderDTO create(OrderDTO orderDTO);

    /** 查询单个订单信息 */
    OrderDTO findOne(String orderId);

    /** 根据商家ID查询订单列表 */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /** 取消订单 */
    OrderDTO cancel(OrderDTO orderDTO);

    /** 完结订单 */
    OrderDTO finish(OrderDTO orderDTO);

    /** 支付订单 */
    OrderDTO paid(OrderDTO orderDTO);

    /** 查询所有订单列表 */
    Page<OrderDTO> findList(Pageable pageable);
}
