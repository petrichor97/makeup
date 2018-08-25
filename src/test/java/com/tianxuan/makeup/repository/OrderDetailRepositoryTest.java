package com.tianxuan.makeup.repository;

import com.tianxuan.makeup.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * 功能描述: 订单详情测试类
 * <p>
 * 作者: luohongquan
 * 日期: 2018/5/4 0004 13:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234567810");
        orderDetail.setOrderId("11111112");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductId("1111111");
        orderDetail.setProductName("馒头");
        orderDetail.setProductQuantity(1);
        orderDetail.setProductPrice(new BigDecimal(0.01));

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {

        List<OrderDetail> orderDetailList = repository.findByOrderId("11111112");
        Assert.assertNotEquals(0, orderDetailList.size());
    }
}