package com.tianxuan.makeup.converter;

import com.tianxuan.makeup.dataobject.OrderMaster;
import com.tianxuan.makeup.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**  
 * 功能描述: OrderMaster转成OrderDTO
 * <p>
 * 作者: luohongquan
 * 日期: 2018/5/5 16:47
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster) {

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(e ->
                convert(e)).collect(Collectors.toList());
    }
}
