package com.tianxuan.makeup.repository;

import com.tianxuan.makeup.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    ProductCategoryRepository repository;

    @Test
    public void findByCategoryTypeInTest1() {
        List<ProductCategory> productCategory = repository.findAll();
        System.out.println(productCategory.get(0).toString());
    }

    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("男生最爱",4);
        repository.save(productCategory);
        //Assert.assertNotNull(null, new Result());
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotNull(null,result.size());
    }
}