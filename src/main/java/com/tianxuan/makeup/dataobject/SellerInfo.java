package com.tianxuan.makeup.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @program: makeup
 * @description:
 * @author: Petrichor
 * @create: 2018-08-20 15:51
 **/
@Data
@Entity
public class SellerInfo {


    @Id
    private String sellerId;

    private String username;

    private String password;

}
