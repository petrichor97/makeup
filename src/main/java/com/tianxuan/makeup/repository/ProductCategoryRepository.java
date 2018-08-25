package com.tianxuan.makeup.repository;

import com.tianxuan.makeup.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 功能描述: 类目 数据层
 * <p>
 * 作者: luohq
 * 日期: 2018/3/11 15:00
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);
}
