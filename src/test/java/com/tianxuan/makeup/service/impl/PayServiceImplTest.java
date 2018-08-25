package com.tianxuan.makeup.service.impl;

import com.tianxuan.makeup.dto.OrderDTO;
import com.tianxuan.makeup.service.OrderService;
import com.tianxuan.makeup.service.PayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PayServiceImplTest {


    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void refund() {
        OrderDTO orderDTO = orderService.findOne("153457356101951634");
        payService.refund(orderDTO);
    }

}