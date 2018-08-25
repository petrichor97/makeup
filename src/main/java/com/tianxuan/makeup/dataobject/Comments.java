package com.tianxuan.makeup.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @program: makeup
 * @description: 商家评价类
 * @author: Petrichor
 * @create: 2018-08-22 16:44
 **/
@Data
@Entity
@DynamicUpdate
public class Comments {

    @Id
    private String username;

    private Date rateTime;

    private Date deliveryTime;

    private Integer score;

    private Integer rateType;

    private String text;

    private String avatar;

    private String productId;

}
