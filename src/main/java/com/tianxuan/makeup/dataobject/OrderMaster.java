package com.tianxuan.makeup.dataobject;

import com.tianxuan.makeup.enums.OrderStatusEnum;
import com.tianxuan.makeup.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @program: makeup
 * @description:
 * @author: Petrichor
 * @create: 2018-08-16 09:35
 **/
@Data
@Entity
@DynamicUpdate
public class OrderMaster {

    /** 订单id */
    @Id
    private String orderId;

    /** 买家名字 */
    private String buyerName;

    /** 买家电话 */
    private String buyerPhone;

    /** 买家地址 */
    private String buyerAddress;

    /** 买家微信openid */
    private String buyerOpenid;

    /** 订单总金额 */
    private BigDecimal orderAmount;

    /** 订单状态，0：新下单（默认）1：已完成 2：取消 */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态，0：未支付（默认）1：已支付 */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;
}
