package com.tianxuan.makeup.service;

import com.tianxuan.makeup.dataobject.SellerInfo;

/**
 * @program: makeup
 * @description:
 * @author: Petrichor
 * @create: 2018-08-20 16:09
 **/
public interface SellerService {

    SellerInfo findSellerInfoBysellerId(String sellerId);
}
