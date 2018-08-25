package com.tianxuan.makeup.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class InviteRegister {
    @Id
    private int inviteRegisterId;

    private String inviteUserOpenid;

    private String beInviteUserOpenid;

}
