package com.tianxuan.makeup.service.impl;

import com.tianxuan.makeup.dataobject.SellerInfo;
import com.tianxuan.makeup.repository.SellerInfoRepository;
import com.tianxuan.makeup.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: makeup
 * @description:
 * @author: Petrichor
 * @create: 2018-08-20 16:10
 **/
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoBysellerId(String sellerId) {
        return repository.findBysellerId(sellerId);
    }
}
