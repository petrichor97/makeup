package com.tianxuan.makeup.entity;

import lombok.Data;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class ChargeMoney{
    @Id
    private String orderId;

    private String openid;

    private BigDecimal money;

    private String chargeTime;

    private String maker;
}
