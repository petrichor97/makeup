package com.tianxuan.makeup.excpetion;

import com.tianxuan.makeup.enums.ResultEnum;
import lombok.Getter;

/**
 * 功能描述: 自定义全局异常类，处理业务时，抛出该异常
 * <p>
 * 作者: luohongquan
 * 日期: 2018/5/4 0004 15:03
 */
@Getter
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
