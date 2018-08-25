package com.tianxuan.makeup.pojo;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class UserWelfareIdAndWelfareName {
    private int userWelfareId;
    private String welfareName;

    public UserWelfareIdAndWelfareName(int userWelfareId, String welfareName) {
        this.userWelfareId = userWelfareId;
        this.welfareName = welfareName;
    }
}