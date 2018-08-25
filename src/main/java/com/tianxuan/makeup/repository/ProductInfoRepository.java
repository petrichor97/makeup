package com.tianxuan.makeup.repository;


import com.tianxuan.makeup.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 功能描述: 商品 Dao层
 * <p>
 * 作者: luohq
 * 日期: 2018/3/11 20:25
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String>{

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
