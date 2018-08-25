package com.tianxuan.makeup.repository;

import com.tianxuan.makeup.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * 功能描述: 订单主表测试
 * <p>
 * 作者: luohongquan
 * 日期: 2018/5/4 0004 13:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    public final String OPPENID = "123123";

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("咸鱼");
        orderMaster.setBuyerOpenid("123123");
        orderMaster.setBuyerPhone("13636445678");
        orderMaster.setBuyerAddress("杭州");
        orderMaster.setOrderAmount(new BigDecimal(22.99));
        orderMaster.setOrderStatus(0);

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() {
        // 构造分页参数
        PageRequest request = new PageRequest(0, 1);

        Page<OrderMaster> result =  repository.findByBuyerOpenid(OPPENID, request);
        Assert.assertNotEquals(0, result.getTotalElements());
    }
}