package com.tianxuan.makeup.converter;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tianxuan.makeup.dataobject.OrderDetail;
import com.tianxuan.makeup.dto.OrderDTO;
import com.tianxuan.makeup.enums.ResultEnum;
import com.tianxuan.makeup.excpetion.SellException;
import com.tianxuan.makeup.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: OrderForm转OrderDTO
 * <p>
 * 作者: luohongquan
 * 日期: 2018/5/6 14:53
 */
@Slf4j
public class OrderForm2OrderDTOConveter {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误， string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
