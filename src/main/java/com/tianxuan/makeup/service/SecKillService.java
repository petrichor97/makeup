package com.tianxuan.makeup.service;

/**
 * 功能描述: 秒杀Service
 * <p>
 * 作者: luohongquan
 * 日期: 2018/5/9 0009 10:28
 */
public interface SecKillService {

    /**
     * 查询商品信息
     * @param productId
     * @return
     */
    String querySecKillProductInfo(String productId);

    /**
     * 秒杀活动：下单，减库存，结束活动
     * @param productId
     */
    void orderProductMockDiffUser(String productId);
}
