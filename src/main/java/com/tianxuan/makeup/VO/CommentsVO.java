package com.tianxuan.makeup.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: makeup
 * @description:
 * @author: Petrichor
 * @create: 2018-08-22 13:32
 **/
@Data
public class CommentsVO implements Serializable {

    private static final long serialVersionUID = -5390067623716449336L;

    @JsonProperty("username")
    private String username;

    @JsonProperty("rateTime")
    private Long rateTime;

    @JsonProperty("deliveryTime")
    private Integer deliveryTime;

    @JsonProperty("score")
    private Integer score;

    @JsonProperty("rateType")
    private Integer rateType;

    @JsonProperty("text")
    private String text;

    @JsonProperty("avatar")
    private String avatar;

    @JsonProperty("recommend")
    private List<String> recommend;

}
