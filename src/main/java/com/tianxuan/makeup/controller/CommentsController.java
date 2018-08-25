package com.tianxuan.makeup.controller;

import com.tianxuan.makeup.VO.ApiVO;
import com.tianxuan.makeup.VO.CommentsVO;
import com.tianxuan.makeup.dataobject.Comments;
import com.tianxuan.makeup.service.CommentsService;
import com.tianxuan.makeup.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: makeup
 * @description:
 * @author: Petrichor
 * @create: 2018-08-22 13:13
 **/
@RestController
@RequestMapping("/api")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;
    @Autowired
    private ProductService productService;

    @GetMapping("/ratings.json")
    @Cacheable(cacheNames = "comment" ,key = "456",unless = "#result.getCode() != 0 ")
    public ApiVO list(){
        ApiVO apiVo = new ApiVO();
         apiVo.setCode(0);

         //查到所有评价并封装
           List<Comments> comments = commentsService.findAll();
           List<CommentsVO> commentsVOList = new ArrayList<>();
           for(Comments comments1 : comments ){
               CommentsVO commentsVO = new CommentsVO();
               commentsVO.setUsername(comments1.getUsername());
               commentsVO.setRateTime(comments1.getRateTime().getTime());
               commentsVO.setScore(comments1.getScore());
               commentsVO.setDeliveryTime(0);
               commentsVO.setRateType(comments1.getRateType());
               commentsVO.setText(comments1.getText());
               commentsVO.setAvatar(comments1.getAvatar());
               List<String> list = new ArrayList<>();
               list.add(productService.findOne(comments1.getProductId()).getProductName());
               commentsVO.setRecommend(list);
               commentsVOList.add(commentsVO);
           }
        apiVo.setData(commentsVOList);
        return apiVo;
    }



}
