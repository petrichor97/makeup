package com.tianxuan.makeup.repository;

import com.tianxuan.makeup.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: makeup
 * @description:
 * @author: Petrichor
 * @create: 2018-08-20 15:53
 **/
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findBysellerId(String sellerId);
}


