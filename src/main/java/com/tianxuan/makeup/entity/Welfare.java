package com.tianxuan.makeup.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Welfare {
    @Id
    private int welfareId;
    private String welfareName;

//    @JoinTable(name = "user_welfare",joinColumns = {
//            @JoinColumn(name = "welfare_id", referencedColumnName = "welfare_id")}, inverseJoinColumns = {
//            @JoinColumn(name = "user_id", referencedColumnName = "user_id")})
//    @ManyToMany
//    private Set<TxVipUser> txVipUsers;
}
