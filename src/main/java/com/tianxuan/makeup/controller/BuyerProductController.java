package com.tianxuan.makeup.controller;

import com.tianxuan.makeup.VO.ProductInfoVO;
import com.tianxuan.makeup.VO.ProductVO;
import com.tianxuan.makeup.VO.ResultVO;
import com.tianxuan.makeup.dataobject.ProductCategory;
import com.tianxuan.makeup.dataobject.ProductInfo;
import com.tianxuan.makeup.service.CategoryService;
import com.tianxuan.makeup.service.ProductService;
import com.tianxuan.makeup.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: makeup
 * @description:
 * @author: Petrichor
 * @create: 2018-08-15 19:58
 **/
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {


    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    @Cacheable(cacheNames = "product" ,key = "123",unless = "#result.getCode() != 0 ")
    public ResultVO list() {
        // 1. 查询所有上架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        // 2. 查询类目（一次性查询）
        // 传统方法
//        List<Integer> categoryTypeList = new ArrayList<>();
//        for (ProductInfo productInfo : productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }

        // 精简方法（Java8，lambda）
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        // 3. 数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();

            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);

                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
