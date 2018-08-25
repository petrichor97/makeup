package com.tianxuan.makeup.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tianxuan.makeup.enums.ProductStatusEnum;
import com.tianxuan.makeup.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: makeup
 * @description:
 * @author: Petrichor
 * @create: 2018-08-15 19:16
 **/
@Data
@Entity
@DynamicUpdate
public class ProductInfo {

    @Id
    private String productId;

    /** 名字 */
    private String productName;

    /** 单价 */
    private BigDecimal productPrice;

    /** 库存 */
    private Integer productStock;

    /** 描述 */
    private String productDescription;

    /** 小图 */
    private String productIcon;

    /** 状态，0：正常，1：下架 */
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /** 类目编号 */
    private Integer categoryType;

    private Date createTime;
    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }

}
