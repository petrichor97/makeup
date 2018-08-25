package com.tianxuan.makeup.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class TxVipUser {
    @Id
    private String openid;

    private String password;

    private String name;

    private String sex;

    private String school;

    private String institute;

    private String grade;
//@Temporal(TemporalType.DATE)
    private Date birthday;

    private String skin;

    private String isNew;

    private BigDecimal money;
    //积分
    private int integral;

    private String invitationCode;
    @Transient
    private String beInvitationCode;

}