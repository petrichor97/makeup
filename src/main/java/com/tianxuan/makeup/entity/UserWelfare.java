package com.tianxuan.makeup.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class UserWelfare {

    @Id
    private int userWelfareId;

    private String openid;

    private int welfareId;


}
