package com.tianxuan.makeup.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * 功能描述: http请求返回的最外层对象
 * <p>
 * 作者: luohq
 * 日期: 2018/3/13 20:14
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 3866399847321963863L;

    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 具体内容 */
    private T data;
}
