package com.tianxuan.makeup.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: makeup
 * @description:
 * @author: Petrichor
 * @create: 2018-08-22 13:25
 **/
@Data
public class ApiVO<T> implements Serializable {

    private static final long serialVersionUID = 8537999847321963863L;

    /** 错误码 */
    @JsonProperty("errno")
    private Integer code;

    /** 具体内容 */
    @JsonProperty("data")
    private T data;
}
