package com.tianxuan.makeup.utils;


import com.tianxuan.makeup.VO.ResultVO;

/**
 * 功能描述: ResultVO工具类
 * <p>
 * 作者: luohq
 * 日期: 2018/3/13 21:14
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
