package com.tianxuan.makeup.service;


import com.tianxuan.makeup.dataobject.ProductInfo;
import com.tianxuan.makeup.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 功能描述: 商品
 * <p>
 * 作者: luohq
 * 日期: 2018/3/11 20:30
 */
public interface ProductService {

    ProductInfo findOne(String productInfoId);

    /**
     * 查询所有在架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /**
     * 功能描述: 取消订单时，加库存
     * <p>
     * 作者: luohongquan
     * 日期: 2018/5/4 0004 15:56
     */
    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 功能描述: 下订单时，件库存
     * <p>
     * 作者: luohongquan
     * 日期: 2018/5/4 0004 15:55
     */
    void decreaseStock(List<CartDTO> cartDTOList);

    /**
     * 功能描述: 上架
     * <p>
     * 作者: luohongquan
     * 日期: 2018/5/8 0008 10:33
     */
    ProductInfo onSale(String productId);

    /**
     * 功能描述: 下架
     * <p>
     * 作者: luohongquan
     * 日期: 2018/5/8 0008 10:33
     */
    ProductInfo offSale(String productId);
}
